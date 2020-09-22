package OODesign;

import java.util.ArrayList;
import java.util.List;

class ATMUser {
    private int cardNo;
    private String password;

    public int getCardNo() {
        return cardNo;
    }

    public void setCardNo(int cardNo) {
        this.cardNo = cardNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

class UserData {
    private int AcctNo;
    private int cardNo;
    private String password;
    private double amount;

    public int getAcctNo() {
        return AcctNo;
    }

    public void setAcctNo(int acctNo) {
        AcctNo = acctNo;
    }

    public int getCardNo() {
        return cardNo;
    }

    public void setCardNo(int cardNo) {
        this.cardNo = cardNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

class ATMDesign {
    private int totalATMAmount;
    private List<UserData> userDataList = new ArrayList<>();
    private UserData userData = null;

    public void authorize(ATMUser user) {
        for (UserData userData1 : userDataList) {
            if (userData1.getCardNo() == user.getCardNo()) {
                if (userData1.getPassword().equals(user.getPassword())) {
                    userData = userData1;
                } else {
                    System.out.println("Pin Verification failed");
                }
            } else {
                System.out.println("NO USER FOUND");
            }

        }
    }

    public boolean isCashAvailableInATm() {
        return totalATMAmount > 0;
    }

    public void withdraw(ATMUser atmUser, int amount) {
        if (!isCashAvailableInATm())
            System.out.println("No Cash Available in ATM");
        else if (amount > userData.getAmount()) {
            System.out.println("Insuffiecient Funds");
        }else {
            System.out.println("With draw success:Amount Available:"+(userData.getAmount()-amount));
        }
    }

}
