import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends  JFrame {

    JTextArea txtArea1;
    JTextArea txtArea2;
    JScrollPane scp1;
    JScrollPane scp2;
    JComboBox cmb1;
    Border border;

    public Main(String title){
        super( title );
        setDefaultCloseOperation(3);
        setSize(755,500);//400 width and 500 height
        setLayout(null);//using no layout managers
        setLocationRelativeTo(null);

        txtArea1 = new JTextArea();
        txtArea2 = new JTextArea();
        txtArea2.setEditable(false); // set textArea non-editable
        txtArea1.setBounds(5,5,300, 400);
        txtArea2.setBounds(430,5,300, 400);
        txtArea1.setLineWrap(true);
        txtArea2.setLineWrap(true);

        border = BorderFactory.createLineBorder(Color.BLACK);
        txtArea1.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        txtArea2.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        txtArea1.setFont(new Font("Verdana", Font.BOLD, 12));
        txtArea2.setFont(new Font("Verdana", Font.BOLD, 12));

        scp1 = new JScrollPane(txtArea1);
        scp2 = new JScrollPane(txtArea2);
        scp1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scp2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        cmb1 = new JComboBox();
        cmb1.setBounds(50, 410, 100, 30);
        cmb1.addItem("JAVA");
        cmb1.addItem("XML");

        JButton btnConvertir=new JButton("Convertir");//creating instance of JButton
        btnConvertir.setBounds(320,100,100, 40);//x axis, y axis, width, height
        btnConvertir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Convertidor1 con = new Convertidor1();
                if ( txtArea1.getText().trim().length()== 0){
                    JOptionPane.showMessageDialog(null, "Debe ingresar texto");
                }else{
                    String mensaje = "";

                    if (cmb1.getSelectedIndex() == 0){
                        String convertido = con.convertirClaseToJson(txtArea1.getText().toString());
                        txtArea1.setText("");
                        if (convertido.equals("1")){
                            txtArea2.setText("Ingrese texto en el formato: \n" +
                                    "nombre, apeidoP, apeidoM, matricula");
                            mensaje = "Conversion fallida";
                        }else{
                            txtArea2.setText(convertido);
                            mensaje = "Conversion de texto java";
                        }
                    }else {
                        txtArea2.setText(con.convertirXmlToJson(txtArea1.getText().toString()));
                        txtArea1.setText("");
                        mensaje = "Conversion de texto XML";

                    }
                    JOptionPane.showMessageDialog(null, mensaje);
                }
            }
        });

        add(btnConvertir);//adding button in JFrame
        add(txtArea1);
        add(txtArea2);
        add(cmb1);

    }


    public static void main(String[] args) {
        System.out.println("Hello, world");
        Main mframe = new Main("Convetidor");
        mframe.setVisible(true);//making the frame visible
    }
}