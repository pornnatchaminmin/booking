package GUI;

import javax.swing.*;

import lib.Room;
import lib.RoomSystem;
import lib.User;

import java.awt.*;
import java.awt.event.*;
import java.time.*;
import java.util.*;

//ค่อนข้างเสร็จ
public class listbook extends JFrame {
        DefaultListModel<String> ModelList1;
        DefaultListModel<String> ModelList2;
        int year, month, day;
        int hourStart = 13;
        int hourEnd = 23;
        int minuteStartEnd = 00;
        User user;
        Room room;
        RoomSystem system;

        public listbook(User user, Room room) {
                this.user = user;
                this.room = room;

                system = new RoomSystem();
                year = LocalDate.now().getYear();
                month = LocalDate.now().getMonthValue();
                day = LocalDate.now().getDayOfMonth();
                // System.out.println(day + " " + month + " " + year);
                ModelList1 = new DefaultListModel<>();
                ModelList2 = new DefaultListModel<>();
                for (int i = 0; i < hourEnd - hourStart; i++) {// ปรับการจัดเวลา24:00
                        if (!(system.checkLocalDateTimeIsSame(room,
                                        LocalDateTime.of(year, month, day, hourStart + i, minuteStartEnd)))) {
                                ModelList1.addElement((hourStart + i) + ":" + minuteStartEnd + "0-"
                                                + (hourStart + i + 1) + ":"
                                                + minuteStartEnd + "0"); // ยังมีบัค24:00
                        }
                }
                initComponents();
        }

        private void initComponents() {
                jPanel1 = new JPanel();
                jPanel2 = new JPanel();
                jLabel1 = new JLabel();
                jScrollPane1 = new JScrollPane();
                jList1 = new JList<>();
                jScrollPane2 = new JScrollPane();
                jList2 = new JList<>();
                jButton1 = new JButton();
                jButton2 = new JButton();
                jButton3 = new JButton();

                setResizable(false);
                setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                setSize(new Dimension(250, 350));
                setLocationRelativeTo(null);

                jPanel1.setBackground(new Color(235, 240, 255));

                jPanel2.setBackground(new Color(255, 255, 255));

                jLabel1.setFont(new Font("Tw Cen MT", 1, 24)); // NOI18N
                jLabel1.setText("BOOK A TIME");

                GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(19, 19, 19)
                                                                .addComponent(jLabel1)
                                                                .addContainerGap(19, Short.MAX_VALUE)));
                jPanel2Layout.setVerticalGroup(
                                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addContainerGap()));

                jScrollPane1.setBackground(new Color(255, 241, 234));

                jList1.setBackground(new Color(255, 241, 234));
                jList1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
                jList1.setModel(ModelList1);
                jScrollPane1.setViewportView(jList1);

                jList2.setBackground(new Color(255, 241, 234));
                jList2.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
                jList2.setModel(ModelList2);
                jScrollPane2.setViewportView(jList2);

                jButton1.setBackground(new Color(183, 255, 207));
                jButton1.setFont(new Font("MS Gothic", 0, 18)); // NOI18N
                jButton1.setText("Add Room");
                jButton1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
                jButton1.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                                jButtonAddRoom(evt);
                        }
                });

                jButton2.setBackground(new Color(255, 107, 131));
                jButton2.setFont(new Font("MS Gothic", 0, 18)); // NOI18N
                jButton2.setForeground(new Color(255, 255, 255));
                jButton2.setText("Remove Room");
                jButton2.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                                jButtonRemoveRoom(evt);
                        }
                });
                // jButton2.setBorder(new border.MatteBorder());

                jButton3.setBackground(new Color(205, 255, 255));
                jButton3.setFont(new Font("MS Gothic", 0, 18)); // NOI18N
                jButton3.setText("Confirm");
                jButton3.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
                jButton3.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                                jButtonConfirmRoom(evt);
                        }
                });

                GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                GroupLayout.Alignment.TRAILING)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jButton1,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                120,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(jButton2,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                134,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(30, 30, 30)
                                                                                                .addComponent(jButton3,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                96,
                                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(GroupLayout.Alignment.LEADING,
                                                                                                jPanel1Layout.createSequentialGroup()
                                                                                                                .addComponent(jScrollPane1,
                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                191,
                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                .addPreferredGap(
                                                                                                                                LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                                31,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(jScrollPane2,
                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                192,
                                                                                                                                GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(19, 19, 19))
                                                .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout
                                                                .createSequentialGroup()
                                                                .addContainerGap(GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addGap(130, 130, 130)));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(12, 12, 12)
                                                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jScrollPane2,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                155,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addContainerGap(
                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE))
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jScrollPane1,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                155,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                34,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                GroupLayout.Alignment.BASELINE)
                                                                                                                .addComponent(jButton1,
                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                39,
                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(jButton2,
                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                39,
                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(jButton3,
                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                39,
                                                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                                                .addGap(32, 32, 32)))));

                GroupLayout layout = new GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE)));
                layout.setVerticalGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void jButtonRemoveRoom(ActionEvent evt) {
                if (jList2.getSelectedValue() != null) {
                        // System.out.println(jList2.getSelectedValue());
                        ModelList1.addElement(jList2.getSelectedValue());
                        ArrayList<String> listSort = Collections.list(ModelList1.elements());
                        Collections.sort(listSort);
                        ModelList1.clear();
                        for (int i = 0; i < listSort.size(); i++) {
                                ModelList1.addElement(listSort.get(i));
                        }
                        ModelList2.removeElementAt(jList2.getSelectedIndex());
                        jList2.setModel(ModelList2);
                        jList1.setModel(ModelList1);
                }
        }

        private void jButtonAddRoom(ActionEvent evt) {
                if (jList1.getSelectedValue() != null) {
                        ModelList2.addElement(jList1.getSelectedValue());
                        ArrayList<String> listSort = Collections.list(ModelList2.elements());
                        Collections.sort(listSort);
                        ModelList2.clear();
                        for (int i = 0; i < listSort.size(); i++) {
                                ModelList2.addElement(listSort.get(i));
                        }
                        ModelList1.removeElementAt(jList1.getSelectedIndex());
                        jList2.setModel(ModelList2);
                        jList1.setModel(ModelList1);
                }
        }

        private void jButtonConfirmRoom(ActionEvent evt) {
                for (int i = 0; i < ModelList2.size(); i++) {
                        String tempModel = ModelList2.get(i);
                        String[] tempArray = tempModel.split("[:\\-]");
                        system.addBookRoom(room, user,
                                        LocalDateTime.of(year, month, day, Integer.parseInt(tempArray[0]),
                                                        Integer.parseInt(tempArray[1])),
                                        LocalDateTime.of(year, month, day, Integer.parseInt(tempArray[2]),
                                                        Integer.parseInt(tempArray[3])));
                }
                ModelList2.clear();
                jList2.setModel(ModelList2);
        }

        /**
         * @param args the command line arguments
         */
        public static void main(String args[]) {
                RoomSystem system = new RoomSystem();
                Room room1 = new Room("1-5", 101, 150);
                User user1 = new User(2);
                system.addBookRoom(room1, user1,
                                LocalDateTime.of(LocalDate.now().getYear(), LocalDate.now().getMonth(),
                                                LocalDate.now().getDayOfMonth(),
                                                12, 0, 0),
                                LocalDateTime.of(LocalDate.now().getYear(), LocalDate.now().getMonth(),
                                                LocalDate.now().getDayOfMonth(),
                                                13, 0, 0));
                system.addBookRoom(room1, user1,
                                LocalDateTime.of(LocalDate.now().getYear(), LocalDate.now().getMonth(),
                                                LocalDate.now().getDayOfMonth(),
                                                15, 0, 0),
                                LocalDateTime.of(LocalDate.now().getYear(), LocalDate.now().getMonth(),
                                                LocalDate.now().getDayOfMonth(),
                                                16, 0, 0));
                try {
                        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                                if ("Nimbus".equals(info.getName())) {
                                        UIManager.setLookAndFeel(info.getClassName());
                                        break;
                                }
                        }
                } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(listbook.class.getName()).log(java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(listbook.class.getName()).log(java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(listbook.class.getName()).log(java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(listbook.class.getName()).log(java.util.logging.Level.SEVERE,
                                        null, ex);
                }
                // </editor-fold>

                /* Create and display the form */
                EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new listbook(new User(1), new Room("1-5", 101, 150)).setVisible(true);
                        }
                });
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private JButton jButton1;
        private JButton jButton2;
        private JButton jButton3;
        private JLabel jLabel1;
        private JList<String> jList1;
        private JList<String> jList2;
        private JPanel jPanel1;
        private JPanel jPanel2;
        private JScrollPane jScrollPane1;
        private JScrollPane jScrollPane2;
        // End of variables declaration//GEN-END:variables
}
