package main

import (
	"fmt"
	"time"
)

type Wallet struct {
	balance         int
	transactions    []Transaction
	savingsGoal     int
}

type Transaction struct {
	date  time.Time
	desc  string
}

func (w *Wallet) displayBalance() {
	fmt.Printf("Your current balance is: %d Ar\n", w.balance)
}

func (w *Wallet) addFunds() {
	var amount int
	fmt.Print("Enter the amount to add: ")
	fmt.Scan(&amount)

	w.balance += amount
	w.transactions = append(w.transactions, Transaction{time.Now(), fmt.Sprintf("Added %d Ar to wallet", amount)})

	fmt.Printf("Added %d Ar to wallet\n", amount)
}

func (w *Wallet) subtractFunds() {
	var amount int
	fmt.Print("Enter the amount to subtract: ")
	fmt.Scan(&amount)

	if amount <= w.balance {
		w.balance -= amount
		w.transactions = append(w.transactions, Transaction{time.Now(), fmt.Sprintf("Subtracted %d Ar from wallet", amount)})
		fmt.Printf("Subtract %d Ar from wallet\n", amount)
	} else {
		fmt.Println("Insufficient funds. Transaction canceled.")
	}
}

func (w *Wallet) setSavingsGoal() {
	fmt.Print("Enter your savings goal amount: ")
	fmt.Scan(&w.savingsGoal)
	fmt.Printf("Savings goal set to %d Ar.\n", w.savingsGoal)
}

func (w *Wallet) trackSavingsProgress() {
	fmt.Printf("Current savings progress: %d / %d Ar\n", w.balance, w.savingsGoal)
}

func (w *Wallet) getAllTransactions() {
	for _, t := range w.transactions {
		fmt.Printf("%s: %s\n", t.date.Format(time.RFC3339), t.desc)
	}
}

func main() {
	wallet := Wallet{}

	fmt.Println("Welcome to the wallet program")
	for {
		fmt.Println(`
		1. Display Balance
		2. Add Funds
		3. Subtract Funds
		4. Set Savings Goal
		5. Track Savings Progress
		6. View All Transactions
		7. Quit
		`)

		var choice int
		fmt.Print("Choose an option (1-7): ")
		fmt.Scan(&choice)

		switch choice {
		case 1:
			wallet.displayBalance()
		case 2:
			wallet.addFunds()
		case 3:
			wallet.subtractFunds()
		case 4:
			wallet.setSavingsGoal()
		case 5:
			wallet.trackSavingsProgress()
		case 6:
			wallet.getAllTransactions()
		case 7:
			fmt.Println("Exiting wallet program. Goodbye!")
			return
		default:
			fmt.Println("Invalid choice. Please choose a number between 1 and 7.")
		}
	}
}
