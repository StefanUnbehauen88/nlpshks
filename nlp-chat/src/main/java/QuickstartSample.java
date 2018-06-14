
// Imports the Google Cloud client library

public class QuickstartSample
{

    /**
     * Demonstrates using the Speech API to transcribe an audio file.
     */
    public static void main(final String... args) throws Exception
    {
        // System.setProperty("https.proxyHost", "proxy-web.sha.vrkw.de");
        // System.setProperty("https.proxyPort", "8080");
        // System.setProperty("https.proxyUser", "k292292");
        // System.setProperty("https.proxyPassword", "");

        final TTSClient ttsClient = new TTSClient();

        ttsClient.createAudioFromText("hallo, das ist ein TEst von Stefan");

        // Instantiates a client
        /*try (SpeechClient speechClient = SpeechClient.create())
        {

            // The path to the audio file to transcribe
            final String fileName = "C:\\ccstg\\bshweb\\src\\hackathon\\nlp-chat\\src\\main\\resources\\text_to_speech.flac";

            // Reads the audio file into memory
            final Path path = Paths.get(fileName);
            final byte[] data = Files.readAllBytes(path);
            final ByteString audioBytes = ByteString.copyFrom(data);

            // Builds the sync recognize request
            final RecognitionConfig config = RecognitionConfig.newBuilder().setEncoding(AudioEncoding.LINEAR16).setSampleRateHertz(16000)
                    .setLanguageCode("en-US").build();
            final RecognitionAudio audio = RecognitionAudio.newBuilder().setContent(audioBytes).build();

            // Performs speech recognition on the audio file
            final RecognizeResponse response = speechClient.recognize(config, audio);
            final List<SpeechRecognitionResult> results = response.getResultsList();

            for (final SpeechRecognitionResult result : results)
            {
                // There can be several alternative transcripts for a given chunk of speech. Just use the
                // first (most likely) one here.
                final SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
                System.out.printf("Transcription: %s%n", alternative.getTranscript());
            }
        }*/
    }
}
