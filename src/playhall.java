import javax.swing.*;
import java.awt.*;

public class playhall {
    private JLabel jl1, jl2, jl3, jl4;
    JTabbedPane tabbedPane;
    JPanel homepanel, showpanel, userpanel;// 一个是游戏大厅，一个是游戏房间
    JSplitPane jsp, jsp1;
    ImageIcon icon;
    playhall(JLabel ll, String username) {
        JFrame frame = new JFrame();
        tabbedPane = new JTabbedPane();
        homepanel = new JPanel();
        showpanel = new JPanel();
        userpanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        jl1 = new JLabel("用户信息");
        jl2 = ll; // 头像
        jl3 = new JLabel(username); // 用户名
        jl4 = new JLabel("服务器信息");

        icon=new ImageIcon("home.jpg");
        icon.setImage(icon.getImage().getScaledInstance(10,10,Image.SCALE_DEFAULT));

        showpanel.setLayout(new GridLayout(5, 3, 20, 20));
        for (int i = 1; i <= 15; i++) {
            JPanel tablePanel = new JPanel(new GridLayout(1, 2, 10, 10));
            tablePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            // 创建一个座位面板
            JPanel seatPanel = createSeatPanel();
            tablePanel.add(seatPanel);

            seatPanel = createSeatPanel();
            tablePanel.add(seatPanel);

            showpanel.add(tablePanel);

            // 每行三个桌子，创建一个新的行
            if (i % 3 == 0) {
                showpanel.add(new JPanel()); // 添加一个空面板，只是为了保持GridLayout的布局
            }
        }

        userpanel.add(jl1);
        userpanel.add(jl3);
        userpanel.add(jl2);

        homepanel.setLayout(new BorderLayout());
        homepanel.add(showpanel, BorderLayout.CENTER);

        JSplitPane jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        jsp.setDividerLocation(130);
        jsp.setRightComponent(homepanel);
        jsp.setLeftComponent(createUserInfoPanel());

        tabbedPane.addTab("游戏大厅",icon , jsp);
        frame.setContentPane(tabbedPane);
        frame.setTitle("网络对战平台");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    private JPanel createSeatPanel() {
        JPanel seatPanel = new JPanel(new BorderLayout());
        JButton seatButton = new JButton("座位");
        seatButton.setBackground(Color.LIGHT_GRAY); // 设置座位按钮的背景颜色为浅灰色
        seatButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        seatButton.setPreferredSize(new Dimension(20, 20)); // 设置座位按钮的大小

        seatPanel.add(seatButton, BorderLayout.CENTER);
        return seatPanel;
    }

    private JPanel createUserInfoPanel() {
        JPanel userInfoPanel = new JPanel(new BorderLayout());
        JSplitPane jsp1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        jsp1.setDividerLocation(200);

        jsp1.setLeftComponent(userpanel);
        jsp1.setRightComponent(jl4);

        userInfoPanel.add(jsp1, BorderLayout.CENTER);

        return userInfoPanel;
    }

}
