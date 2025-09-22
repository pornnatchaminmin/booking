package GUI;

import javax.swing.*;

import lib.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.*;

public class book extends JFrame {
        JLabel[] jLabelRoom;
        JLabel[] jLabelAvalible;
        JLabel[] jLabelCost;
        JPanel[] jPanelBooking;
        JButton[] jButton;
        LocalDate date;
        RoomSystem system;
        Font FontITCKRIST;
        Font FontTWCENMT;
        User user;

        public book(User user, RoomSystem system) {
                this.system = system;
                this.user = user;
                jLabelRoom = new JLabel[100];//
                jLabelAvalible = new JLabel[100];//
                jLabelCost = new JLabel[100];//
                jPanelBooking = new JPanel[100];//
                jButton = new JButton[100];//

                setUpFont();
                setUpLookAndFeel();

                setResizable(false);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setSize(new Dimension(390, 664));
                setLocationRelativeTo(null);
                initComponents();
        }

        private void initComponents() {

                jLabel1 = new JLabel();
                jLabel2 = new JLabel();
                jMoney = new JLabel();
                jBookingButton = new JButton();
                jMyBooking = new JButton();
                jLabel4 = new JLabel();
                jComboBoxDate = new JComboBox<>();
                jScrollPane1 = new JScrollPane();
                jLabel5 = new JLabel();
                jLabel11 = new JLabel();
                jButton3 = new JButton();
                jRoomId1 = new JLabel();
                jAccom1 = new JLabel();
                jBooking1 = new JButton();
                jRoomId = new JLabel();
                jAccommodate = new JLabel();
                jBooking = new JButton();
                jLogOut = new JButton();
                jOrderFood = new JButton();
                jTopUp = new JButton();
                jOpen = new JLabel();
                jPleaseTopUp = new JLabel();

                jPanel1 = new JPanel();
                jPanel2 = new JPanel();
                jPanel3 = new JPanel();
                jPanel4 = new JPanel();
                jPanelRoom = new JPanel();
                jPanel6 = new JPanel();
                jPanel7 = new JPanel();
                jPanel8 = new JPanel();
                jPanel9 = new JPanel();

                jPanel1.setBackground(new Color(235, 240, 255));
                jPanel1.setPreferredSize(new Dimension(390, 664));

                jLabel2.setFont(FontITCKRIST.deriveFont((float) 14)); // NOI18N
                jLabel2.setText("BOOK A ROOM");

                jPanel2.setBackground(new Color(255, 255, 204));

                jMoney.setBackground(new Color(255, 255, 255));
                jMoney.setFont(FontTWCENMT.deriveFont((float) 14).deriveFont((int) 1)); // NOI18N
                jMoney.setText("MONEY :");// ไว้แก้Money

                GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jMoney, GroupLayout.DEFAULT_SIZE, 68,
                                                                                Short.MAX_VALUE)
                                                                .addGap(56, 56, 56)));
                jPanel2Layout.setVerticalGroup(
                                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jMoney)
                                                                .addContainerGap(GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                jPanel3.setBackground(new Color(0, 0, 0));
                jPanel3.setBorder(
                                BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1), null));
                jPanel3.setPreferredSize(new Dimension(0, 5));

                GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
                jPanel3.setLayout(jPanel3Layout);
                jPanel3Layout.setHorizontalGroup(
                                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGap(0, 0, Short.MAX_VALUE));
                jPanel3Layout.setVerticalGroup(
                                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGap(0, 0, Short.MAX_VALUE));

                jBookingButton.setBackground(new Color(210, 242, 255));
                jBookingButton.setFont(FontTWCENMT.deriveFont((float) 18)); // NOI18N
                jBookingButton.setText("BOOKING");
                jBookingButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                                jButton1ActionPerformed(evt);
                        }
                });

                jMyBooking.setBackground(new Color(210, 242, 255));
                jMyBooking.setFont(FontTWCENMT.deriveFont((float) 18)); // NOI18N
                jMyBooking.setText("MY BOOKING");
                jMyBooking.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                                jButton2ActionPerformed(evt);
                        }
                });
                //
                jPanel4.setBackground(new Color(255, 254, 241));

                jLabel4.setFont(FontTWCENMT.deriveFont((float) 14).deriveFont((int) 1)); // NOI18N
                jLabel4.setText("WHAT KIND OF ROOM WOLD YOU LIKE ?");

                jComboBoxDate.setModel(
                                new DefaultComboBoxModel<>(
                                                new String[] { "Today", LocalDate.now().plusDays(1).toString(),
                                                                LocalDate.now().plusDays(2).toString() }));
                jComboBoxDate.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                String tempS = (String) jComboBoxDate.getSelectedItem();
                                if (tempS.equals("Today")) {
                                        date = LocalDate.now();
                                } else {
                                        String[] tempSplit = tempS.split("[-]");
                                        date = LocalDate.of(Integer.parseInt(tempSplit[0]),
                                                        Integer.parseInt(tempSplit[1]), Integer.parseInt(tempSplit[2]));
                                }
                        }

                });
                jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

                // ----------------------------- SetupRoom --------------------------------
                int x = 20, y = 20, count = 0;
                jPanelRoom.setLayout(null);
                jPanelRoom.setBackground(new Color(255, 254, 241));
                int i = 0;
                for (Room room : system.getRooms()) {
                        jLabelRoom[i] = new JLabel();
                        jLabelRoom[i].setFont(FontTWCENMT.deriveFont((float)18).deriveFont(1));
                        jLabelRoom[i].setText("Room" + room.getIdRoom());
                        jLabelRoom[i].setAlignmentX(Component.CENTER_ALIGNMENT);

                        jLabelAvalible[i] = new JLabel();
                        jLabelAvalible[i].setFont(FontTWCENMT.deriveFont((float)18).deriveFont(1));
                        jLabelAvalible[i].setText("For : "+room.getNameRoom());
                        jLabelAvalible[i].setHorizontalAlignment(SwingConstants.CENTER);
                        jLabelAvalible[i].setAlignmentX(Component.CENTER_ALIGNMENT);

                        jLabelCost[i] = new JLabel();
                        jLabelCost[i].setFont(FontTWCENMT.deriveFont((float)18).deriveFont(1));
                        jLabelCost[i].setText("Cost : "+room.getPrice());
                        jLabelCost[i].setHorizontalAlignment(SwingConstants.CENTER);
                        jLabelCost[i].setAlignmentX(Component.CENTER_ALIGNMENT);

                        jButton[i] = new RoundedButton(30, 30, Color.BLACK);
                        jButton[i].setBackground(new Color(255, 183, 198));
                        jButton[i].setPreferredSize(new Dimension(100, 50));
                        jButton[i].setFont(FontTWCENMT.deriveFont((float)18).deriveFont(1));
                        jButton[i].setText("Booking");
                        jButton[i].setForeground(Color.WHITE);
                        jButton[i].setAlignmentX(Component.CENTER_ALIGNMENT);
                        jButton[i].putClientProperty(1,
                                        new Room(room.getNameRoom(), room.getIdRoom(), room.getPrice()));
                        jButton[i].addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                        JButton tempButton = (JButton) e.getSource();//
                                        Room tempRoom = (Room) tempButton.getClientProperty(1);
                                        System.out.println(tempRoom);
                                        if (date == null) {
                                                date = LocalDate.now();
                                        }
                                        listbook list = new listbook(new User(1,150), tempRoom, book.this, date);
                                        list.setVisible(true);
                                }
                        });
                        jPanelBooking[i] = new RoundedPanel(30, 30, Color.black);

                        jPanelBooking[i].setBackground(Color.white);
                        jPanelBooking[i].setLayout(new BoxLayout(jPanelBooking[i], BoxLayout.Y_AXIS));

                        int tempInt = 10;
                        jPanelBooking[i].setBorder(BorderFactory.createEmptyBorder(tempInt, tempInt, tempInt, tempInt));

                        jPanelBooking[i].add(jLabelRoom[i]);
                        jPanelBooking[i].add(jLabelAvalible[i]);
                        jPanelBooking[i].add(jLabelCost[i]);

                        jPanelBooking[i].add(Box.createVerticalStrut(10));
                        jPanelBooking[i].add(jButton[i]);

                        if ((i + 1) % 2 == 0) {
                                x = 205;
                        } else {
                                x = 15;
                        }
                        if (count == 2) {
                                count = 0;
                                y += 140;
                        }
                        jPanelBooking[i].setBounds(x, y, 175, 125);
                        count++;
                        jPanelRoom.add(jPanelBooking[i]);
                        i++;
                }
                int maxHeight = 0;
                for (Component comp : jPanelRoom.getComponents()) {
                        Rectangle bounds = comp.getBounds();
                        maxHeight = Math.max(maxHeight, bounds.y + bounds.height);
                }
                jPanelRoom.setPreferredSize(new Dimension(getSize().width, maxHeight + 50));
                JScrollPane scroll = new JScrollPane(jPanelRoom);
                add(scroll);
                // ----------------------------- SetupRoom --------------------------------
                jScrollPane1.setViewportView(jPanelRoom);
                jScrollPane1.setBorder(BorderFactory.createEmptyBorder());
                //jScrollPane1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

                GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
                jPanel4.setLayout(jPanel4Layout);
                jPanel4Layout.setHorizontalGroup(
                                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout
                                                                .createSequentialGroup()
                                                                .addGap(14, 14, 14)
                                                                .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 265,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(jComboBoxDate, GroupLayout.PREFERRED_SIZE,
                                                                                82, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(14, 14, 14))
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE,
                                                                                0, Short.MAX_VALUE)
                                                                .addContainerGap()));
                jPanel4Layout.setVerticalGroup(
                                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                                .addGap(12, 12, 12)
                                                                .addGroup(jPanel4Layout.createParallelGroup(
                                                                                GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel4,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                38,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jComboBoxDate,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                23,
                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE,
                                                                                320, Short.MAX_VALUE)
                                                                .addContainerGap()));

                jLogOut.setBackground(new Color(255, 89, 100));
                jLogOut.setForeground(new Color(255, 255, 255));
                jLogOut.setText("X");

                jOrderFood.setBackground(new Color(255, 228, 207));
                jOrderFood.setFont(FontTWCENMT.deriveFont((float) 18)); // NOI18N
                jOrderFood.setText("ORDER FOOD");

                jTopUp.setBackground(new Color(204, 255, 204));
                jTopUp.setFont(FontTWCENMT.deriveFont((float) 18)); // NOI18N
                jTopUp.setText("TOP UP");
                jTopUp.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                                jButton11ActionPerformed(evt);
                        }
                });

                jPanel6.setBackground(new Color(255, 255, 255));

                jOpen.setFont(FontITCKRIST.deriveFont((float) 18)); // NOI18N
                jOpen.setText("OPEN 12 : 00 P.M. - 23 : 00 P.M.");

                GroupLayout jPanel11SetJOpen = new GroupLayout(jPanel6);
                jPanel6.setLayout(jPanel11SetJOpen);
                jPanel11SetJOpen.setHorizontalGroup(
                                jPanel11SetJOpen.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel11SetJOpen.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jOpen)
                                                                .addContainerGap(0, Short.MAX_VALUE)));
                jPanel11SetJOpen.setVerticalGroup(
                                jPanel11SetJOpen.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel11SetJOpen.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jOpen)
                                                                .addContainerGap(GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                jPleaseTopUp.setFont(new Font("Segoe UI", 0, 10)); // NOI18N
                jPleaseTopUp.setForeground(new Color(255, 0, 0));
                jPleaseTopUp.setText("* PLEASE TOP UP TO USE THE APP");

                GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel1)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jLogOut)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                GroupLayout.Alignment.LEADING, false)
                                                                                .addComponent(jPanel3,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                121, Short.MAX_VALUE)
                                                                                .addComponent(jLabel2,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addGap(15, 15, 15))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jPanel4,
                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addContainerGap())
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                GroupLayout.Alignment.LEADING)
                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addComponent(jMyBooking,
                                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                                136,
                                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addPreferredGap(
                                                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                .addComponent(jBookingButton,
                                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                                136,
                                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addPreferredGap(
                                                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                .addComponent(jOrderFood,
                                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                                136,
                                                                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                                                                .addComponent(jTopUp,
                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                136,
                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(jPleaseTopUp,
                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                193,
                                                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                                                .addGap(0, 8, Short.MAX_VALUE))
                                                                                .addGroup(GroupLayout.Alignment.TRAILING,
                                                                                                jPanel1Layout.createSequentialGroup()
                                                                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                                                                .addComponent(jPanel6,
                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                .addGap(85, 85, 85)))));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                GroupLayout.Alignment.TRAILING)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(18, 18, 18)
                                                                                                .addGroup(
                                                                                                                jPanel1Layout.createParallelGroup(
                                                                                                                                GroupLayout.Alignment.LEADING)
                                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                                .createSequentialGroup()
                                                                                                                                                .addGap(11, 11, 11)
                                                                                                                                                .addComponent(jLabel1))
                                                                                                                                .addComponent(jLogOut))
                                                                                                .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.UNRELATED,
                                                                                                                21,
                                                                                                                Short.MAX_VALUE))
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                GroupLayout.Alignment.TRAILING)
                                                                                                                .addComponent(jPanel2,
                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addComponent(jLabel2,
                                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                                25,
                                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addGap(3, 3, 3)
                                                                                                                                .addComponent(jPanel3,
                                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                                2,
                                                                                                                                                GroupLayout.PREFERRED_SIZE)))
                                                                                                .addGap(18, 18, 18)))
                                                                .addComponent(jPanel6, GroupLayout.PREFERRED_SIZE,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jOrderFood,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                37,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(0, 2, Short.MAX_VALUE))
                                                                                .addComponent(jBookingButton,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                39, Short.MAX_VALUE)
                                                                                .addComponent(jMyBooking,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addPreferredGap(
                                                                                LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jTopUp, GroupLayout.PREFERRED_SIZE, 37,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addGap(4, 4, 4)
                                                                .addComponent(jPleaseTopUp)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addGap(37, 37, 37)));

                GroupLayout layout = new GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE));
                layout.setVerticalGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE));

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void jButton1ActionPerformed(ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_jButton1ActionPerformed

        private void jButton2ActionPerformed(ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_jButton2ActionPerformed

        private void jComboBox1ActionPerformed(ActionEvent evt) {// GEN-FIRST:event_jComboBox1ActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_jComboBox1ActionPerformed

        private void jButton11ActionPerformed(ActionEvent evt) {// GEN-FIRST:event_jButton11ActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_jButton11ActionPerformed

        /**
         * @param args the command line arguments
         */
        private void setUpFont() {
                File fileTwCenMT = new File("./Font/TwCenMT.ttf");
                File fileITCKRIST = new File("./Font/ITCKRIST.ttf");
                try {
                        FontITCKRIST = Font.createFont(Font.TRUETYPE_FONT, fileITCKRIST).deriveFont((int) 1);
                        FontTWCENMT = Font.createFont(Font.TRUETYPE_FONT, fileTwCenMT).deriveFont((int) 0);
                } catch (Exception e) {
                        System.out.println(e);
                }
        }

        private void setUpLookAndFeel() {
                try {
                        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                                if ("Nimbus".equals(info.getName())) {
                                        UIManager.setLookAndFeel(info.getClassName());
                                        break;
                                }
                        }
                } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(book.class.getName()).log(java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(book.class.getName()).log(java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(book.class.getName()).log(java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(book.class.getName()).log(java.util.logging.Level.SEVERE,
                                        null, ex);
                }
        }

        public static void main(String args[]) {
                RoomSystem system = new RoomSystem();
                for (int i = 0; i < 10; i++) {
                        Room a = new Room("1-5", 301 + i, 150);
                        system.addRoom(a);
                }
                system.addRoom(new Room("5+", 201, 150));
                new book(new User(1,150), system).setVisible(true);
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private JButton jBookingButton;
        private JButton jOrderFood;
        private JButton jTopUp;
        private JButton jBooking1;
        private JButton jBooking;
        private JButton jMyBooking;
        private JButton jButton3;
        private JButton jLogOut;
        private JComboBox<String> jComboBoxDate;
        private JLabel jLabel1;
        private JLabel jLabel11;
        private JLabel jAccom1;
        private JLabel jLabel2;
        private JLabel jOpen;
        private JLabel jAccommodate;
        private JLabel jMoney;
        private JLabel jLabel4;
        private JLabel jLabel5;
        private JLabel jPleaseTopUp;
        private JLabel jRoomId1;
        private JLabel jRoomId;

        private JPanel jPanel1;
        private JPanel jPanel2;
        private JPanel jPanel3;
        private JPanel jPanel4;
        private JPanel jPanelRoom;
        private JPanel jPanel6;
        private JPanel jPanel7;
        private JPanel jPanel8;
        private JPanel jPanel9;
        private JScrollPane jScrollPane1;
}

class RoundedPanel extends JPanel {
        private int arcWidth;
        private int arcHeight;
        private Boolean HaveBorderColor;
        private Color Border;

        public RoundedPanel(int arcWidth, int arcHeight, Color Border) {
                this.arcWidth = arcWidth;
                this.arcHeight = arcHeight;
                this.Border = Border;
                HaveBorderColor = true;
                setOpaque(false); // ให้พื้นหลังโปร่งใส จะได้ไม่ทับโค้ง
        }

        public RoundedPanel(int arcWidth, int arcHeight) {
                this.arcWidth = arcWidth;
                this.arcHeight = arcHeight;
                HaveBorderColor = false;
                setOpaque(false); // ให้พื้นหลังโปร่งใส จะได้ไม่ทับโค้ง
        }

        @Override
        protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();

                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                if (HaveBorderColor) {
                        g2.setColor(Border);
                } else {
                        g2.setColor(getBackground());
                }
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), arcWidth, arcHeight);

                g2.setColor(getBackground());
                g2.fillRoundRect(4, 4, getWidth() - 8, getHeight() - 8, arcWidth, arcHeight);

                g2.dispose();
                super.paintComponent(g);
        }
}

class RoundedButton extends JButton {
        private int arcWidth;
        private int arcHeight;
        private Boolean HaveBorderColor;
        private Color Border;

        public RoundedButton(int arcWidth, int arcHeight, Color Border) {
                this.arcWidth = arcWidth;
                this.arcHeight = arcHeight;
                this.Border = Border;
                HaveBorderColor = true;
                setContentAreaFilled(false); // ปิด default fill
                setFocusPainted(false);
                setOpaque(false); // ให้พื้นหลังโปร่งใส จะได้ไม่ทับโค้ง
        }

        public RoundedButton(int arcWidth, int arcHeight) {
                this.arcWidth = arcWidth;
                this.arcHeight = arcHeight;
                HaveBorderColor = false;

                setContentAreaFilled(false); // ปิด default fill
                setFocusPainted(false);

                setOpaque(false); // ให้พื้นหลังโปร่งใส จะได้ไม่ทับโค้ง
        }

        @Override
        protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                if (HaveBorderColor) {
                        g2.setColor(Border);
                } else {
                        g2.setColor(getBackground());
                }
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), arcWidth, arcHeight);

                g2.setColor(getBackground());
                g2.fillRoundRect(2, 2, getWidth() - 4, getHeight() - 4, arcWidth, arcHeight);

                g2.dispose();
                super.paintComponent(g);
        }
}
