

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BankClientFrame extends JFrame {
	private JTextField _accountNameField;
	private JTextField _balanceTextField;
	private JTextField _withdrawalTextField;
	private JTextField _depositTextField;
	private Account _account;

	protected void buildGUI() {
		JPanel contentPane = new JPanel(new BorderLayout());
		contentPane.add(buildActionPanel(), BorderLayout.CENTER);
		contentPane.add(buildBalancePanel(), BorderLayout.SOUTH);
		setContentPane(contentPane);
		setSize(250, 100);
		this.show();
	}

	private void resetBalanceField() {
		try {
			Money balance = _account.getBalance();
			_balanceTextField.setText("Balance: " + balance.toString());
		} catch (Exception e) {
			System.out.println("Error occurre d while getting account balance\n" + e);
		}
	}

	private JPanel buildActionPanel() {
		JPanel actionPanel = new JPanel(new GridLayout(3, 3));
		actionPanel.add(new JLabel("Account Name:"));
		_accountNameField = new JTextField();
		actionPanel.add(_accountNameField);
		JButton getBalanceButton = new JButton("Get Balance");
		getBalanceButton.addActionListener(new GetBalanceAction());
		actionPanel.add(getBalanceButton);
		actionPanel.add(new JLabel("Withdraw"));
		_withdrawalTextField = new JTextField();
		actionPanel.add(_withdrawalTextField);
		JButton withdrawalButton = new JButton("Do it");
		withdrawalButton.addActionListener(new WithdrawAction());
		actionPanel.add(withdrawalButton);
		actionPanel.add(new JLabel("Deposit"));
		_depositTextField = new JTextField();
		actionPanel.add(_depositTextField);
		JButton depositButton = new JButton("Do it");
		depositButton.addActionListener(new DepositAction());
		actionPanel.add(depositButton);
		return actionPanel;

	}

	private JPanel buildBalancePanel() {
		JPanel balancePanel = new JPanel(new GridLayout(1, 2));
		balancePanel.add(new JLabel("Current Balance:"));
		_balanceTextField = new JTextField();
		_balanceTextField.setEnabled(false);
		balancePanel.add(_balanceTextField);
		return balancePanel;
	}

	private void getAccount() {
		try {
			_account = (Account) Naming.lookup("rmi://localhost:1099/Sachin");
		} catch (Exception e) {
			System.out.println("Couldn't find account. Error was \n " + e);
			e.printStackTrace();
		}
		return;
	}

	private void releaseAccount() {
		_account = null;
	}

	private Money readTextField(JTextField moneyField) {
		try {
			Float floatValue = new Float(moneyField.getText());
			float actualValue = floatValue.floatValue();
			int cents = (int) (actualValue * 100);
			return new PositiveMoney(cents);
		} catch (Exception e) {
			System.out.println("Field doesn't contain a valid value");
		}
		return null;
	}

	private class GetBalanceAction implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				getAccount();
				resetBalanceField();
				releaseAccount();
			} catch (Exception exception) {
				System.out.println("Couldn't talk to account. Error was " + exception);
			}
		}
	}

	private class WithdrawAction implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				getAccount();
				Money withdrawalAmount = readTextField(_withdrawalTextField);
				_account.makeWithdrawal(withdrawalAmount);
				_withdrawalTextField.setText("");
				resetBalanceField();
				releaseAccount();
			} catch (Exception exception) {
				System.out.println("Couldn't talk to account. Error was \n " + exception);
				exception.printStackTrace();
			}
		}
	}

	private class DepositAction implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				getAccount();
				Money depositAmount = readTextField(_depositTextField);
				_account.makeDeposit(depositAmount);
				_depositTextField.setText("");
				resetBalanceField();
				releaseAccount();
			} catch (Exception exception) {
				System.out.println("Couldn't talk to account. Error was" + exception);
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
