const prompt = require('prompt-sync')();

class Wallet {
    constructor() {
        this.balance = 0;
        this.transactions = [];
        this.savings_goal = 0;
    }

    displayBalance() {
        console.log(`Your current balance is: ${this.balance}`);
    }

    addFunds() {
        let amount = parseInt(prompt("Enter the amount to add: "));
        this.balance += amount;
        this.transactions.push([new Date(), `Added ${amount} Ar to wallet`]);
        console.log(`Added ${amount} Ar to wallet`);
    }

    subtractFunds() {
        let amount = parseInt(prompt("Enter the amount to subtract: "));
        if (amount <= this.balance) {
            this.balance -= amount;
            this.transactions.push([new Date(), `Subtracted ${amount} Ar from wallet`]);
            console.log(`Subtract ${amount} Ar from wallet`);
        } else {
            console.log("Insufficient funds. Transaction canceled.");
        }
    }

    setSavingsGoal() {
        this.savings_goal = parseInt(prompt("Enter your savings goal amount: "));
        console.log(`Savings goal set to ${this.savings_goal} Ar.`);
    }

    trackSavingsProgress() {
        console.log(`Current savings progress: ${this.balance} / ${this.savings_goal} Ar`);
    }

    getAllTransactions() {
        for (let [date, desc] of this.transactions) {
            console.log(`${date}: ${desc}`);
        }
    }
}

let wallet = new Wallet();

console.log("Welcome to the wallet program");
while (true) {
    console.log(`
        1. Display Balance
        2. Add Funds
        3. Subtract Funds
        4. Set Savings Goal
        5. Track Savings Progress
        6. View All Transactions
        7. Quit
    `)

    let choice = parseInt(prompt('Choose an option (1-7): '));

    if (choice === 1) {
        wallet.displayBalance();
    } else if (choice === 2) {
        wallet.addFunds();
    } else if (choice === 3) {
        wallet.subtractFunds();
    } else if (choice === 4) {
        wallet.setSavingsGoal();
    } else if (choice === 5) {
        wallet.trackSavingsProgress();
    } else if (choice === 6) {
        wallet.getAllTransactions();
    } else if (choice === 7) {
        console.log("Exiting wallet program. Goodbye!");
        break;
    } else {
        console.log("Invalid choice. Please choose a number between 1 and 7.");
    }
}
