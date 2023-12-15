import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

public class loginhall extends JFrame implements MouseListener{
    private JFrame frame;
    private JButton jb1,jb2,jb3;
    private JPanel jp1,jp2,jp3;
    private JLabel jl1,jl2,jl3;
    private JTextField jf;//文本框用于接收用户名
    private JPasswordField jpf;//密码框用于接收用户密码
    private JFileChooser jfc;//用于查找文件来实现头像的选择
    private ImageIcon icon;
    private  int x,y;//坐标
    public static final int BOARD_SIZE=15;
    chessboard [][]chessboards=new chessboard[BOARD_SIZE][BOARD_SIZE];
    public loginhall()
    {
        jp1=new JPanel();
        jp2=new JPanel();
        jp3=new JPanel();

        jl1=new JLabel("用户名");
        jl2=new JLabel("密 码");
        jl3=new JLabel();//用于显示头像的

        jb1=new JButton("登 录");
        jb2=new JButton("头像选择");
        jb3=new JButton("退 出");

        jf=new JTextField(10);//设置长度
        jpf=new JPasswordField(10);//同理

        jfc=new JFileChooser();

        jp1.add(jl3);
        jp1.add(jl1);
        jp1.add(jf);

        jp2.add(jl2);
        jp2.add(jpf);

        jp3.add(jb1);
        jp3.add(jb2);
        jp3.add(jb3);

        add(jp1);
        add(jp2);
        add(jp3);


        setTitle("五子棋游戏");
//        setLayout(new GridLayout(3,3,1,2));
       setLayout(new FlowLayout());
        setVisible(true);
        setSize(600,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        addMouseListener(this);
//        frame.add(button1);
//        frame.add(button2);
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username=jf.getText();
                String passward= String.valueOf(jpf.getPassword());
                dispose();
                //大厅的创建
                new playhall(jl3,username);
            }
        });

        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        jfc.addChoosableFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if(f.getName().toLowerCase().endsWith(".jpg"))
                {
                    return true;
                }
                return false;
            }

            @Override
            public String getDescription() {
                return "图片文件(*.jpg)";
            }
        });

        jb2.addActionListener(new ActionListener() { //选择头像按钮
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = jfc.showOpenDialog(null); //打开文件选择器
                if (option == JFileChooser.APPROVE_OPTION) { //如果用户选择了文件
                    File file = jfc.getSelectedFile(); //获取用户选择的文件
                    if (file != null) {
                        icon = new ImageIcon(file.getAbsolutePath()); //创建图标对象
                        icon.setImage(icon.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT)); //设置图标大小
                        jl3.setIcon(icon); //给标签设置图标
                    }
                }
            }
        });
    }
//    public void paint(Graphics g) {
//        g.setColor(Color.yellow);
//        g.fillRect(100,100,420,420);
//        g.setColor(Color.black);
//        for(int i=0;i<BOARD_SIZE;i++)
//        {
//            g.drawLine(100,100+30*i,520,100+30*i);
//            g.drawLine(100+30*i,100,100+30*i,520);//来之不易 累累的
//        }
//    }
    public void mouseClicked(MouseEvent e)
    {
        int px=e.getX();
        int py=e.getY();
        if(px>100&&px<520&&py>100&&py<520)
        {

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void play()
    {

    }
    }

