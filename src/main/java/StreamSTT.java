import com.assemblyai.api.RealtimeTranscriber;

import javax.sound.sampled.*;
import java.io.IOException;

import static java.lang.Thread.interrupted;

public final class StreamSTT {

    public static void main(String... args) throws IOException {
        // List all available target data lines
        Mixer.Info[] mixerInfos = AudioSystem.getMixerInfo();
        System.out.println("Available mixers:");
        for (Mixer.Info info : mixerInfos) {
            System.out.println(info.getName());
        }

        Thread thread = new Thread(() -> {
            try {
                RealtimeTranscriber realtimeTranscriber = RealtimeTranscriber.builder()
                        .apiKey("f27d22a4637d40e980ff5c73ffafb38d")
                        .sampleRate(16_000)
                        .onSessionBegins(sessionBegins -> System.out.println(
                                "Session opened with ID: " + sessionBegins.getSessionId()))
                        .disablePartialTranscripts()
                        .endUtteranceSilenceThreshold(1000)
                        .onFinalTranscript(transcript -> System.out.println("Word types: " + transcript.getWords()))
                        .onError(err -> System.out.println("Error: " + err.getMessage()))
                        .build();

                System.out.println("Connecting to real-time transcript service");
                realtimeTranscriber.connect();

                System.out.println("Starting recording");
                AudioFormat format = new AudioFormat(16_000, 16, 1, true, false);
                TargetDataLine line = AudioSystem.getTargetDataLine(format);
                line.open(format);
                byte[] data = new byte[line.getBufferSize()];
                line.start();
                while (!interrupted()) {
                    line.read(data, 0, data.length);
                    realtimeTranscriber.sendAudio(data);
                }


                System.out.println("Stopping recording");
                line.close();

                System.out.println("Closing real-time transcript connection");
                realtimeTranscriber.close();
            } catch (LineUnavailableException e) {
                System.out.println("LineUnavailableException: " + e.getMessage());
                throw new RuntimeException(e);
            }
        });
        thread.start();

        System.out.println("Press ENTER key to stop...");
        System.in.read();
        thread.interrupt();
        System.exit(0);
    }
}
