import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class GUI extends JFrame {

    private JPanel panel;
    private JLabel ekran;
    private JButton a0Button1;
    private JButton button3;
    private JButton a3Button;
    private JButton a2Button;
    private JButton _Button;
    private JButton xButton;
    private JButton bölmebutton;
    private JButton cButton;
    private JButton a7Button;
    private JButton a4Button;
    private JButton a1Button;
    private JButton DELButton;
    private JButton a8Button;
    private JButton a5Button;
    private JButton jButton;
    private JButton a9Button;
    private JButton a6Button;
    private JButton plusbutton;
    private JButton esitttirbuton;
    private JScrollPane scrollpane;
    private JPanel panel1;

    private static final int MIN_FONT_SIZE = 20;
    private static final int MAX_FONT_SIZE = 48;

    private Double çarpmailk = 1.0;
    private Double bölmeilk = 1.0;
    private Double toplamailk = 0.0;
    private Double çıkarmailk = 0.0;

    private String işlem = "";


    public void düzenle(double d) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        symbols.setDecimalSeparator('.'); // Ondalık ayırıcı olarak noktayı ayarladık normalde bu method virgül kullanıyor ve bu sefer aşağıdaki işlemlerde sıkıntı çıkıyor

        DecimalFormat df = new DecimalFormat("#.###", symbols); //virgülden sonra max 3 basamak olur
        String formattedValue = df.format(d);

        if (formattedValue.contains(".")) {
            String[] parts = formattedValue.split("\\.");
            int tamSayiKismi = Integer.parseInt(parts[0]);
            int ondalikKismi = Integer.parseInt(parts[1]);

            if (ondalikKismi == 0) {
                ekran.setText(String.valueOf(tamSayiKismi));
            } else {
                ekran.setText(formattedValue);
            }
        } else {
            ekran.setText(formattedValue);
        }
    }



    // Butonları devre dışı bırakma
    private void disableButtons() {
        for (Component component : panel.getComponents()) {
            if (component instanceof JButton) {
                component.setEnabled(false);
            }
        }
    }

    // Butonları tekrar etkinleştirme
    private void enableButtons() {
        for (Component component : panel.getComponents()) {
            if (component instanceof JButton) {
                component.setEnabled(true);
            }
        }
    }

    private void adjustFontSize() {
        Font font = ekran.getFont();
        FontMetrics fm = ekran.getFontMetrics(font);
        int labelWidth = ekran.getWidth();
        int textWidth = fm.stringWidth(ekran.getText());

        // Font boyutunu küçültme
        int fontSize = MAX_FONT_SIZE;
        while (textWidth > labelWidth && fontSize > MIN_FONT_SIZE) {
            fontSize-=2;
            font = font.deriveFont((float) fontSize);
            ekran.setFont(font);
            fm = ekran.getFontMetrics(font);
            textWidth = fm.stringWidth(ekran.getText());

            if(fontSize <= MIN_FONT_SIZE) {
                ekran.setText("");
                fontSize = MAX_FONT_SIZE;
                font = font.deriveFont((float) fontSize);
                ekran.setFont(font);
                ekran.setText("ERROR");
                disableButtons();
                Timer timer = new Timer(2000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ekran.setText("");
                        enableButtons();
                    }
                });
                timer.setRepeats(false);
                timer.start();

            }

        }
    }

    private void addListeners(){
        a0Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a = ekran.getText();
                a += "0";
                ekran.setText(a);
                adjustFontSize();
            }
        });
        a1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a = ekran.getText();
                a += "1";
                ekran.setText(a);
                adjustFontSize();
            }
        });


        a2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a = ekran.getText();
                a += "2";
                ekran.setText(a);
                adjustFontSize();

            }
        });


        a3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a = ekran.getText();
                a += "3";
                ekran.setText(a);
                adjustFontSize();
            }
        });
        a4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a = ekran.getText();
                a += "4";
                ekran.setText(a);
                adjustFontSize();
            }
        });
        a5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a = ekran.getText();
                a += "5";
                ekran.setText(a);
                adjustFontSize();
            }
        });
        a6Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a = ekran.getText();
                a += "6";
                ekran.setText(a);
                adjustFontSize();
            }
        });
        a7Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a = ekran.getText();
                a += "7";
                ekran.setText(a);
                adjustFontSize();
            }
        });
        a8Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a = ekran.getText();
                a += "8";
                ekran.setText(a);
                adjustFontSize();
            }
        });
        a9Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a = ekran.getText();
                a += "9";
                ekran.setText(a);
                adjustFontSize();
            }
        });
        cButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ekran.setText("");
                Font font = new Font(ekran.getFont().getName(), Font.PLAIN, MAX_FONT_SIZE);
                ekran.setFont(font);
                işlem = "";
            }
        });
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(ekran.getText().startsWith("-")) {
                    ekran.setText(ekran.getText().substring(1));
                }
                else {
                    String a = "-" + ekran.getText();
                    ekran.setText(a);
                }
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String a = ekran.getText();
                a += ".";
                ekran.setText(a);
            }
        });
        DELButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(!ekran.getText().isEmpty()){
                    ekran.setText(ekran.getText().substring(0, ekran.getText().length()-1));
                }

            }
        });
        xButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(işlem.equals("toplama")){
                    çarpmailk = toplamailk + Double.valueOf(ekran.getText());
                    ekran.setText("");

                }
                else if(işlem.equals("çıkarma")){
                    çarpmailk = çıkarmailk - Double.valueOf(ekran.getText());
                    ekran.setText("");
                }
                else if(işlem.equals("bölme")){
                    çarpmailk = bölmeilk / Double.valueOf(ekran.getText());
                    ekran.setText("");
                }
                else if(işlem.equals("çarpma")){
                    çarpmailk = çarpmailk * Double.valueOf(ekran.getText());
                    ekran.setText("");
                }
                else {
                    çarpmailk = Double.valueOf(ekran.getText());
                    ekran.setText("");
                }
                işlem = "çarpma";

            }
        });
        plusbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(işlem.equals("toplama")){
                    toplamailk = toplamailk + Double.valueOf(ekran.getText());
                    ekran.setText("");

                }
                else if(işlem.equals("çıkarma")){
                    toplamailk = çıkarmailk - Double.valueOf(ekran.getText());
                    ekran.setText("");
                }
                else if(işlem.equals("bölme")){
                    toplamailk = bölmeilk / Double.valueOf(ekran.getText());
                    ekran.setText("");
                }
                else if(işlem.equals("çarpma")){
                    toplamailk = çarpmailk* Double.valueOf(ekran.getText());
                    ekran.setText("");
                }
                else {
                    toplamailk = Double.valueOf(ekran.getText());
                    ekran.setText("");
                }
                işlem = "toplama";

            }
        });
        _Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(işlem.equals("toplama")){
                    çıkarmailk = toplamailk + Double.valueOf(ekran.getText());
                    ekran.setText("");

                }
                else if(işlem.equals("çıkarma")){
                    çıkarmailk = çıkarmailk - Double.valueOf(ekran.getText());
                    ekran.setText("");
                }
                else if(işlem.equals("bölme")){
                    çıkarmailk = bölmeilk / Double.valueOf(ekran.getText());
                    ekran.setText("");
                }
                else if(işlem.equals("çarpma")){
                    çıkarmailk = çarpmailk * Double.valueOf(ekran.getText());
                    ekran.setText("");
                }
                else {
                    çıkarmailk = Double.valueOf(ekran.getText());
                    ekran.setText("");
                }

                işlem = "çıkarma";

            }
        });
        bölmebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(işlem.equals("toplama")){
                    bölmeilk = toplamailk + Double.valueOf(ekran.getText());
                    ekran.setText("");

                }
                else if(işlem.equals("çıkarma")){
                    bölmeilk = çıkarmailk - Double.valueOf(ekran.getText());
                    ekran.setText("");
                }
                else if(işlem.equals("bölme")){
                    bölmeilk = bölmeilk / Double.valueOf(ekran.getText());
                    ekran.setText("");
                }
                else if(işlem.equals("çarpma")){
                    bölmeilk = çarpmailk* Double.valueOf(ekran.getText());
                    ekran.setText("");
                }
                else {
                    bölmeilk = Double.valueOf(ekran.getText());
                    ekran.setText("");
                }
                işlem = "bölme";

            }
        });
        esitttirbuton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (işlem){
                    case "toplama":
                        double toplamaikinci = Double.valueOf(ekran.getText());
                        double toplamasonuç = toplamailk + toplamaikinci;
                        düzenle(toplamasonuç);
                        işlem = "";
                        break;

                    case "çıkarma" :
                        double çıkarmaikinci = Double.valueOf(ekran.getText());
                        double çıkarmasonuç = çıkarmailk - çıkarmaikinci;
                        düzenle(çıkarmasonuç);
                        işlem = "";
                        break;

                    case "çarpma" :
                        double çarpmaikinci = Double.valueOf(ekran.getText());
                        double çarpmasonuç = çarpmailk * çarpmaikinci;
                        düzenle(çarpmasonuç);
                        işlem = "";
                        break;

                    case("bölme") :
                        double bölmeikinci = Double.valueOf(ekran.getText());
                        double bölmesonuç = bölmeilk / bölmeikinci;
                        düzenle(bölmesonuç);
                        işlem = "";
                        break;

                    default:
                        ekran.setText(String.valueOf(ekran.getText()));
                        işlem = "";
                        break;
                }
            }
        });






    }

    GUI(){
        add(panel);
        setSize(328,280);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        scrollpane.setBackground(panel.getBackground());
        scrollpane.getViewport().setBackground(panel.getBackground());
        ekran.setBackground(panel.getBackground());

        addListeners();


    }










}
