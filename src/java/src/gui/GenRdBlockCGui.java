package gui;

import blockchain.BlockChain;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GenRdBlockCGui {
    private JPanel Dcc;
    private JButton creer;
    private JPanel menu1;
    private JSpinner spinnerdiff;
    private JSpinner spinnernb;
    private JLabel labeldiff;
    private JLabel labelnb;
    private JProgressBar creation;

    public GenRdBlockCGui() {

        creer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                creation.setStringPainted(true);
                creation.setMaximum((int) spinnernb.getValue());
                BlockChain b = new BlockChain((int) spinnerdiff.getValue());
                AddBlockWorker w = new AddBlockWorker(b, (int) spinnernb.getValue(), creation);
                w.execute();
                creation.setValue(0);
            }
        });
        spinnernb.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if ((int) spinnernb.getValue() > 99) {
                    spinnernb.setValue(0);
                }
                if ((int) spinnernb.getValue() < 0) {
                    spinnernb.setValue(99);
                }
            }
        });

        spinnerdiff.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if ((int) spinnerdiff.getValue() > 15) {
                    spinnerdiff.setValue(0);
                }
                if ((int) spinnerdiff.getValue() < 0) {
                    spinnerdiff.setValue(15);
                }
            }
        });
    }

    public JPanel getDcc() {
        return Dcc;
    }
}