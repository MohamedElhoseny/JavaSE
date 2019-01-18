import javax.swing.*;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class FindIP extends JFrame 
{
	//Constructing UI frame components
	public FindIP(String title)
	{
		super(title);
		//set layout
		this.setLayout(null);
		
		//components
		JLabel label = new JLabel("Enter URL :");
		JTextField urlinput = new JTextField(30);
		JButton findBtn = new JButton("Find IP");
		
		//customizing component [setBounds(x, y, width, height)]
		label.setBounds(100,100, 80, 20);
		urlinput.setBounds(200, 100, 250, 20);
		findBtn.setBounds(300, 200, 80, 20);

		//event-handling
		findBtn.addActionListener(ae -> {
			//Handling finding IP
			String urlString = urlinput.getText();
			InetAddress address;
			String message = "";

			try {
				//https://www.google.com.eg/
				String regex = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
				Pattern patt = Pattern.compile(regex);
						Matcher matcher = patt.matcher(urlString);

				if(urlString.isEmpty()){
					String hostid = InetAddress.getLocalHost().getHostAddress().toString();
					message = "URL: localhost "+"\nIP: "+hostid;

				}else if(matcher.matches())
					   {
							address = InetAddress.getByName(new URL(urlString).getHost());
					String hostid = address.getHostAddress();
					message = "URL: "+urlinput.getText()+"\nIP: "+hostid;
						}else {
							message = "Invalid URL Format !";
				}
			} catch (UnknownHostException | MalformedURLException e) {
				message = "Invalid URL Format !";
				e.printStackTrace();
			}

			JOptionPane.showConfirmDialog(FindIP.this, message, "Finding IP ..",JOptionPane.DEFAULT_OPTION);
		});
		
		//adding component to layout
		add(label);
		add(urlinput);
		add(findBtn);
	}

	public static void main(String args[])
	{
		FindIP ui = new FindIP("Lab 1");
		ui.setSize(600, 400);
		ui.setResizable(false);
		ui.setVisible(true);
		ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}