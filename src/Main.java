package src;

import com.fasterxml.jackson.databind.ObjectMapper;
import src.client.ClientServerConnector;
import src.models.RequestBody;
import src.pages.Home;

import javax.swing.*;

public class Main extends JFrame {

    private JLabel label;

    public Main() throws Exception {
        Welcome();
    }

    public void Welcome() throws Exception{

        setTitle("HIRIC");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setIconImage(new ImageIcon("src/img/dv.png").getImage());

        label = new JLabel();
        add(label);

        RequestBody requestBody = new RequestBody();
        requestBody.setUrl("/welcome");
        requestBody.setAction("welcome");
        requestBody.setObject(null);

        String request = new ObjectMapper().writeValueAsString(requestBody);

        ClientServerConnector clientServerConnector = new ClientServerConnector();
        String response = clientServerConnector.connect(request);

        label.setText(response);


        Home home = new Home();
        add(home);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

}