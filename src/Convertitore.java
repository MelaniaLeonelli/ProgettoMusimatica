import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Convertitore {
    private String input;

    public Convertitore(String inputString) {
        this.input = inputString;
    }

    
    public char[] converti() {
        int j = 0;
        char[] note = new char[this.input.length()];
        for (int i = 0; i < this.input.length(); i++) {
            char carattere = this.input.charAt(i);
            if ("aeiouAEIOU".indexOf(carattere) != -1) {
                note[j] = carattere;
                j++;
            }
        }
        return Arrays.copyOf(note, j); // copio solo la parte utile dell'array
    }

    public String creaTesto(String vocali) {
        StringBuilder testo = new StringBuilder();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            for (char vocale : vocali.toCharArray()) {
                String parola = ottieniParolaPerVocale(vocale);
                String notaF = generaCarattereCasuale(parola);
                testo.append("Vocale: ").append(vocale).append(" - Parola: ").append(parola).append(" Nota scelta: ").append(notaF).append("\n");

                // Scrivi notaF nel file
                writer.write(notaF);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return testo.toString();
    }

    private String ottieniParolaPerVocale(char vocale) {
        // implementazione per associare ogni vocale a una parola diversa
        switch (Character.toLowerCase(vocale)) {
            case 'a':
                return "TEcα";
            case 'e':
                return "AFd";
            case 'i':
                return "BGe";
            case 'o':
                return "Caf";
            case 'u':
                return "Dbg";
            default:
                return "";
        }
    }

    public String generaCarattereCasuale(String parola) {
        Random random = new Random();
        int indiceCarattereCasuale = random.nextInt(parola.length());
        char carattereCasuale = parola.charAt(indiceCarattereCasuale);
        return String.valueOf(carattereCasuale);
    }
}
