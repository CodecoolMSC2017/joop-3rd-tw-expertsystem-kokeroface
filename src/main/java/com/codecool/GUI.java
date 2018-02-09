package com.codecool;

import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;

public class GUI extends JFrame {
    private GridLayout experimentLayout = new GridLayout(33, 5);
    private Map<String, Boolean> answers = new HashMap<>();
    private int questionNumber;

    private GUI(String name) {
        super(name);
        setResizable(false);
    }

    private void addComponentsToPane(final Container pane) {
        final JPanel compsToExperiment = new JPanel();
        compsToExperiment.setLayout(experimentLayout);
        JLabel teamName = new JLabel("Team Kokero", JLabel.CENTER);
        JLabel exper = new JLabel("Game Expert System", JLabel.CENTER);
        teamName.setFont(new Font("Dialog", Font.PLAIN, 20));
        exper.setFont(new Font("Dialog", Font.PLAIN, 20));
        compsToExperiment.add(teamName);
        compsToExperiment.add(exper);
        compsToExperiment.setPreferredSize(new Dimension(1000, 800));
        RuleParser ruleP = new RuleParser();
        RuleRepository ruleRepository = new RuleRepository();
        try {
            ruleRepository = ruleP.getRuleRepository();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Iterator<Question> questionIterator = ruleRepository.getIterator();
        JRadioButton button;
        List<JRadioButton> buttons = new ArrayList<>();
        while (questionIterator.hasNext()) {
            questionNumber++;
            Question question = questionIterator.next();
            JLabel label = new JLabel(question.getQuestion());
            compsToExperiment.add(label);
            List<Value> values;
            values = question.getAnswer().getValues();
            ButtonGroup bgroup = new ButtonGroup();
            if (values.get(0) instanceof SingleValue) {
                button = new JRadioButton(values.get(0).getInputPattern().get(0).toString());
                bgroup.add(button);
                buttons.add(button);
                compsToExperiment.add(button);
                button = new JRadioButton(values.get(1).getInputPattern().get(0).toString());
                bgroup.add(button);
                buttons.add(button);
                compsToExperiment.add(button);
            } else {
                for (int j = 0; j < values.get(0).getInputPattern().size(); j++) {
                    button = new JRadioButton(values.get(0).getInputPattern().get(j).toString());
                    bgroup.add(button);
                    buttons.add(button);
                    compsToExperiment.add(button);
                    button = new JRadioButton(values.get(1).getInputPattern().get(j).toString());
                    bgroup.add(button);
                    buttons.add(button);
                    compsToExperiment.add(button);
                }
            }
        }
        compsToExperiment.add(new JLabel(""));
        JButton evaluate = new JButton("Evaluate");
        compsToExperiment.add(evaluate);
        compsToExperiment.add(new JLabel(""));
        JLabel evaluation = new JLabel("");
        JLabel answerEvaluation = new JLabel("");
        compsToExperiment.add(answerEvaluation);
        compsToExperiment.add(evaluation);
        compsToExperiment.add(new JLabel(""));
        pane.add(compsToExperiment, BorderLayout.NORTH);
        pane.add(new JSeparator(), BorderLayout.CENTER);


        evaluate.addActionListener(new ActionListener() {
            int howManyButtonsSelected = 0;

            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < buttons.size(); i++) {
                    if (buttons.get(i).isSelected() == true) {
                        howManyButtonsSelected++;
                    }
                }
                if (howManyButtonsSelected < 7) {
                    evaluation.setText("Please answer every question.");
                } else {
                    RuleParser ruleP = new RuleParser();
                    RuleRepository ruleRepository = new RuleRepository();
                    try {
                        ruleRepository = ruleP.getRuleRepository();
                    } catch (Exception g) {
                        g.printStackTrace();
                    }
                    Iterator<Question> questionIterator = ruleRepository.getIterator();
                    List<String> questions = new ArrayList<>();
                    while (questionIterator.hasNext()) {
                        Question question = questionIterator.next();
                        questions.add(question.getId());
                    }
                    if (buttons.get(0).isSelected()) {
                        answers.put(questions.get(0), true);
                    } else {
                        answers.put(questions.get(0), false);
                    }
                    if (buttons.get(2).isSelected()) {
                        answers.put(questions.get(1), true);
                    } else {
                        answers.put(questions.get(1), false);
                    }
                    if (buttons.get(4).isSelected()) {
                        answers.put(questions.get(2), true);
                    } else {
                        answers.put(questions.get(2), false);
                    }
                    if (buttons.get(6).isSelected()) {
                        answers.put(questions.get(3), true);
                    } else {
                        answers.put(questions.get(3), false);
                    }
                    if (buttons.get(8).isSelected()) {
                        answers.put(questions.get(4), true);
                    } else {
                        answers.put(questions.get(4), false);
                    }
                    if (buttons.get(10).isSelected()) {
                        answers.put(questions.get(5), true);
                    } else {
                        answers.put(questions.get(5), false);
                    }
                    if (buttons.get(12).isSelected() || buttons.get(14).isSelected() || buttons.get(16).isSelected()) {
                        answers.put(questions.get(6), true);
                    } else {
                        answers.put(questions.get(6), false);
                    }


                    ESProviderGUI esp;

                    try {
                        esp = new ESProviderGUI(new FactParser(), new RuleParser());
                        esp.collectAnswers(answers);
                        esp.evaluate();
                        if (esp.getGameCount() > 1) {
                            answerEvaluation.setText("The closest games to your preferences: ");
                            evaluation.setText(esp.evaluate()+", with "+esp.getMaxValueInMap()+" out of "+questionNumber+" matches.");
                        } else {
                            answerEvaluation.setText("We have found the perfect game for you: ");
                            evaluation.setText(esp.evaluate()+", with "+esp.getMaxValueInMap()+" out of "+questionNumber+" matches!");
                        }

                    } catch (Exception f) {
                        f.printStackTrace();
                    }

                }
            }
        });
    }


    private static void createAndShowGUI() {
        GUI frame = new GUI("Expert System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addComponentsToPane(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        UIManager.put("swing.boldMetal", Boolean.TRUE);

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}