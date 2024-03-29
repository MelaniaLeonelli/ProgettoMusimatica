import javax.sound.midi.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Riproduzione {

    public static void main(String[] args) {
        try {
            
            BufferedReader reader = new BufferedReader(new FileReader("output.txt"));

           
            Synthesizer synth = MidiSystem.getSynthesizer();
            synth.open();

          
            MidiChannel channel = synth.getChannels()[0];

      
            int strumento = 1;
            channel.programChange(strumento);
            int velocita = 90; 
            channel.noteOn(60, velocita);

            
            int carattere;
            while ((carattere = reader.read()) != -1) {
                char notaCasuale = (char) carattere;
                int notaMidi = mappaNotaMidi(notaCasuale);
                if (notaMidi != -1) {
                    channel.noteOn(notaMidi, velocita);
                    Thread.sleep(500); //durata di ciascuna nota
                    channel.noteOff(notaMidi);
                }
            }

           
            synth.close();
            reader.close();

        } catch (IOException | MidiUnavailableException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static int mappaNotaMidi(char notaCasuale) {
        switch (notaCasuale) {
            case 'T':
                return 67; //sol
            case 'A':
                return 69; //la
            case 'B':
                return 71; //si
            case 'C':
            	return 72;//do
            case 'D':
            	return 74; //re
            case 'E':
            	return 76; //mi
            case 'F':
            	return 77; //fa
            case 'G':
            	return 79; //sol
            case 'a':
                return 81; // la
            case 'b':
                return 83; // si
            case 'c':
                return 84; // do
            case 'd':
            	return 86;//re
            case 'e':
            	return 88; //mi
            case 'f':
            	return 89; //fa
            case 'g':
            	return 91; //sol
            case 'α':
            	return 92; //la
            	
            default:
                return -1; 
        }
    }
}
