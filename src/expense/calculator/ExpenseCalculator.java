// package expensecalculator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * File: events/ExpenseCalculator.java Package:
 *
 * @author Created on: Mar 27, 2016 Description: Calculate how much money is
 * left after expenses in a month
 */
public class ExpenseCalculator extends Application {

    private Label expMonthlyLabel1 = new Label("Monthly Expenses: ");
    private Label yearIncome = new Label("Yearly Income: ");
    private Label diffMonthly = new Label("Difference (Monthly): ");
    private Label diffYearly = new Label("Difference (Yearly): ");

    private TextField tfMonthly = new TextField("0.0");
    private TextField tfYearlyIncome = new TextField("0.0");
    private TextField tfDiffMonthly = new TextField("0.0");
    private TextField tfDiffYearly = new TextField("0.0");

    private Button reset = new Button("Reset");
    private Button calculate = new Button("Calculate");

    public void start(Stage primaryStage) {

        // create a main grid pane to hold items
        GridPane mainPane = new GridPane();
        mainPane.add(expMonthlyLabel1, 0, 0);
        mainPane.add(yearIncome, 0, 1);
        mainPane.add(diffMonthly, 0, 2);
        mainPane.add(diffYearly, 0, 3);

        mainPane.add(tfMonthly, 1, 0);
        mainPane.add(tfYearlyIncome, 1, 1);
        mainPane.add(tfDiffMonthly, 1, 2);
        mainPane.add(tfDiffYearly, 1, 3);

        mainPane.add(reset, 0, 4);
        mainPane.add(calculate, 1, 4);
        // add items to mainPane here

        // Create a scene and place it in the stage
        Scene scene = new Scene(mainPane, 270, 130);
        primaryStage.setTitle("Expense Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();

        calculate.setOnAction(e -> calculate());
        reset.setOnAction(e -> reset());
        tfMonthly.setOnAction(e -> calculate());
        tfYearlyIncome.setOnAction(e -> calculate());

    }

    private void calculate() {
        double mExpenses = new Double("0.0");
        double yIncome = new Double("0.0");

        if (tfYearlyIncome.getText() != null && !tfYearlyIncome.getText().isEmpty()
                && tfMonthly.getText() != null && !tfMonthly.getText().isEmpty()) {
            yIncome = Double.parseDouble(tfYearlyIncome.getText());
            mExpenses = Double.parseDouble(tfMonthly.getText());
        }
        double yearlyExp = mExpenses * 12;
        double yearDiff = yIncome - yearlyExp;
        double monthDiff = yearDiff / 12.0;

        tfDiffMonthly.setText(String.format("$%.2f",monthDiff));
        tfDiffYearly.setText(String.format("$%.2f", yearDiff));
    }

    private void reset() {
        tfMonthly.setText("0.0");
        tfYearlyIncome.setText("0.0");
        tfDiffMonthly.setText("0.0");
        tfDiffYearly.setText("0.0");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
