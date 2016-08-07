package scanWindow;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
class ScanWindow {

    public static void main(String args[]) {
        Window win = new Window();
        win.setSize(300, 350);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setResizable(false);
        win.setLocationRelativeTo(null);
        win.setVisible(true);

    }
}

class Window extends JFrame {

    public JButton but1;
    public JButton but2;
    public JButton about;
    public JLabel label;
    public JTextArea area;
    public String ip = "";

    public Window() {
        super("IP scanner");
        setLayout(null);

        but1 = new JButton("Scan IP");
        but2 = new JButton("Scan Domain");
        about = new JButton("About");
        but1.setBounds(50, 100, 200, 50);
        but2.setBounds(50, 150, 200, 50);
        about.setBounds(190,290, 80, 30);

        add(but1);
        add(but2);
        add(about);

        theHandler handler = new theHandler();
        but1.addActionListener(handler);
        but2.addActionListener(handler);
        about.addActionListener(handler);
    }

    class theHandler implements ActionListener {

        public void actionPerformed(ActionEvent eve) {

            if (eve.getSource() == but1) {
                dispose();
                new JFrame1();

            }
            if (eve.getSource() == but2) {
                dispose();
                new JFrame2();

            }
            if (eve.getSource() == about) {

                JOptionPane.showMessageDialog(null, "Developed by:\nShravan Kumar\nB111687\nshravank929@gmail.com", "About", JOptionPane.PLAIN_MESSAGE);
            }

        }

        class JFrame1 extends JFrame {

            public JLabel item1, item2;
            public JTextField text1;
            public JButton b1;
            public JScrollPane jp;

            public JFrame1() {
                super("Port Scanner");
                setLayout(new FlowLayout());
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setSize(400, 400);
                setResizable(false);
                setVisible(true);
                setLocationRelativeTo(null);

                item1 = new JLabel("Scanned Ports on the given ip:");
                add(item1);

                area = new JTextArea(10, 30);
                area.setVisible(true);
                area.setEditable(false);
                add(area);
                jp = new JScrollPane(area);
                add(jp, FlowLayout.CENTER);

                item1.setToolTipText("Scans a single ip address");
                text1 = new JTextField("Enter ip here", 20);
                b1 = new JButton("Scan");
                add(text1);
                add(b1);
                action1 ac1 = new action1();
                b1.addActionListener(ac1);
            }

            class action1 implements ActionListener 
            {

                public void actionPerformed(ActionEvent eve) 
                {
                    if (eve.getSource() == b1) 
                    {
                        ip = text1.getText();
                        if(ip.length()<=15)
                        {
                        for (int i = 1; i <65535; i++) 
                        {

                            try {
                                Socket s = new Socket(ip, i);
                                String str = "";
                                str = Integer.toString(i);
                                switch (str) 
                                {
                                    case "20":
                                        area.append(str + "\tFTP data\n");
                                        break;
                                    case "21":
                                        area.append(str + "\tFTP\n");
                                        break;
                                    case "22":
                                        area.append(str + "\tSSH\n");
                                        break;
                                    case "23":
                                        area.append(str + "\tTelnet\n");
                                        break;
                                    case "25":
                                        area.append(str + "\tsmtp\n");
                                        break;
                                    case "43":
                                        area.append(str + "\twhois\n");
                                        break;
                                    case "47":
                                        area.append(str + "\tNI FTP\n");
                                        break;
                                    case "54":
                                        area.append(str + "\tXNS\n");
                                        break;
                                    case "69":
                                        area.append(str + "\tTFTP\n");
                                        break;
                                    case "70":
                                        area.append(str + "\tGopher\n");
                                        break;
                                    case "79":
                                        area.append(str + "\tfinger\n");
                                        break;
                                    case "80":
                                        area.append(str + "\tHTTP\n");
                                        break;
                                    case "110":
                                        area.append(str + "\tPOP3\n");
                                        break;
                                    case "119":
                                        area.append(str + "\tNNTP\n");
                                        break;
                                    case "139":
                                        area.append(str + "\tNetbios-ssn\n");
                                        break;
                                    case "143":
                                        area.append(str + "\tIMAP\n");
                                        break;
                                    case "156":
                                        area.append(str + "\tSQL service\n");
                                        break;
                                    case "445":
                                        area.append(str + "\tMicrosoft-ds\n");
                                        break;
                                    case "514":
                                        area.append(str + "\tShell\n");
                                        break;
                                    case "631":
                                        area.append(str + "\tipp\n");
                                        break;
                                    case "1099":
                                        area.append(str + "\tRMI Registry\n");
                                        break;
                                    case "3306":
                                        area.append(str + "\tmysql\n");
                                        break;
									default :
                                        area.append(str + "\tUnknown\n");
                                        break;
                                }

                            	}//hai 
                            catch (UnknownHostException uhe) 
                            {
                                System.err.println(uhe);
                                break;
                            } 
                            catch (IOException ioe) 
                            {

                            }
                            
                        }
                         area.append("\n");
                    }
                   
                     else
                    	area.append("Error in the given ip format\nRe-enter ip\n");   
                    }
                    
                }
            }

        }

        class JFrame2 extends JFrame {

            public JLabel item1;
            public JTextField text1;
            public JButton b1;
            JScrollPane jp;
            public Socket s = null;

            public JFrame2() {
                super("Port Scanner");
                setLayout(new FlowLayout());
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setSize(400, 400);
                setResizable(false);
                setVisible(true);
                setLocationRelativeTo(null);

                item1 = new JLabel("Scanned Ports on the given ip:");
                add(item1);

                area = new JTextArea(10, 30);
                area.setVisible(true);
                area.setEditable(false);
                add(area);
                jp = new JScrollPane(area);
                add(jp, FlowLayout.CENTER);
                item1.setToolTipText("Scans entire domain");
                text1 = new JTextField("Enter domain here like 10.10.0.", 20);
                b1 = new JButton("Scan");
                add(text1);
                add(b1);
                action2 ac2 = new action2();
                b1.addActionListener(ac2);
            }

            class action2 implements ActionListener {

                public void actionPerformed(ActionEvent eve) {
                    String tmp_ip = "";
                    if (eve.getSource() == b1) {
                        ip = text1.getText();
						if((ip.charAt(ip.length()-1)=='.')&&(ip.length()<=15))
                        {
                        for (int j = 0; j < 50; j++) {
                            tmp_ip = ip + j;
                            area.append("On the ip:" + tmp_ip + "\n");
                            for (int i = 1; i < 65535; i++) {
                                try {
                                    Socket s = new Socket(tmp_ip, i);
                                    String str = "";
                                    str = Integer.toString(i);
                                    switch (str) 
                                    {
                                        case "20":
                                            area.append(str + "\tFTP data\n");
                                            break;
                                        case "21":
                                            area.append(str + "\tFTP\n");
                                            break;
                                        case "22":
                                            area.append(str + "\tSSH\n");
                                            break;
                                        case "23":
                                            area.append(str + "\tTelnet\n");
                                            break;
                                        case "25":
                                            area.append(str + "\tsmtp\n");
                                            break;
                                        case "43":
                                            area.append(str + "\twhois\n");
                                            break;
                                        case "47":
                                            area.append(str + "\tNI FTP\n");
                                            break;
                                        case "54":
                                            area.append(str + "\tXNS\n");
                                            break;
                                        case "69":
                                            area.append(str + "\tTFTP\n");
                                            break;
                                        case "70":
                                            area.append(str + "\tGopher\n");
                                            break;
                                        case "79":
                                            area.append(str + "\tfinger\n");
                                            break;
                                        case "80":
                                            area.append(str + "\tHTTP\n");
                                            break;
                                        case "110":
                                            area.append(str + "\tPOP3\n");
                                            break;
                                        case "119":
                                            area.append(str + "\tNNTP\n");
                                            break;
                                        case "139":
                                            area.append(str + "\tNetbios-ssn\n");
                                            break;
                                        case "143":
                                            area.append(str + "\tIMAP\n");
                                            break;
                                        case "156":
                                            area.append(str + "\tSQL service\n");
                                            break;
                                        case "445":
                                            area.append(str + "\tMicrosoft-ds\n");
                                            break;
                                        case "514":
                                            area.append(str + "\tShell\n");
                                            break;
                                        case "631":
                                            area.append(str + "\tipp\n");
                                            break;
                                        case "1099":
                                            area.append(str + "\tRMI Registry\n");
                                            break;
                                        case "3306":
                                            area.append(str + "\tmysql\n");
                                            break;
										default :
											area.append(str + "\tUnknown\n");
											break;
                                    }
                                } catch (UnknownHostException uhe) {
                                    System.err.println(uhe);
                                    break;
                                } catch (IOException ioe) {

                                }
                            }
                            area.append("\n");

                        }
						}
						else
                        	area.append("Error in the given ip format\nRe-enter ip\n");
                    }
                }
            }
        }
    }
}
