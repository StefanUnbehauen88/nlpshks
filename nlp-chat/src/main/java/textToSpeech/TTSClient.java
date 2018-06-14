/*******************************************************************************
 * Copyright 2018 Schwäbisch Hall Kreditservice GmbH
 ******************************************************************************/

package textToSpeech;

import java.io.FileOutputStream;
import java.io.OutputStream;

import com.google.cloud.texttospeech.v1beta1.AudioConfig;
import com.google.cloud.texttospeech.v1beta1.AudioEncoding;
import com.google.cloud.texttospeech.v1beta1.SsmlVoiceGender;
import com.google.cloud.texttospeech.v1beta1.SynthesisInput;
import com.google.cloud.texttospeech.v1beta1.SynthesizeSpeechResponse;
import com.google.cloud.texttospeech.v1beta1.TextToSpeechClient;
import com.google.cloud.texttospeech.v1beta1.VoiceSelectionParams;
import com.google.protobuf.ByteString;

/**
 * @author k441816
 */
public class TTSClient
{

    /**
     * @param text
     */
    public void createAudioFromText(final String text)
    {
        try
        {
            synthesizeText(text);
        } catch (final Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void synthesizeText(final String text) throws Exception
    {
        // Instantiates a client
        try (TextToSpeechClient textToSpeechClient = TextToSpeechClient.create())
        {
            // Set the text input to be synthesized
            final SynthesisInput input = SynthesisInput.newBuilder().setText(text).build();

            // Build the voice request
            final VoiceSelectionParams voice = VoiceSelectionParams.newBuilder().setLanguageCode("en-US") // languageCode = "en_us"
                    .setSsmlGender(SsmlVoiceGender.FEMALE) // ssmlVoiceGender = SsmlVoiceGender.FEMALE
                    .build();

            // Select the type of audio file you want returned
            final AudioConfig audioConfig = AudioConfig.newBuilder().setAudioEncoding(AudioEncoding.MP3) // MP3 audio.
                    .build();

            // Perform the text-to-speech request
            final SynthesizeSpeechResponse response = textToSpeechClient.synthesizeSpeech(input, voice, audioConfig);

            // Get the audio contents from the response
            final ByteString audioContents = response.getAudioContent();

            // Write the response to the output file.
            try (OutputStream out = new FileOutputStream("output.mp3"))
            {
                out.write(audioContents.toByteArray());
                System.out.println("Audio content written to file \"output.mp3\"");
            }
        }
    }

}
