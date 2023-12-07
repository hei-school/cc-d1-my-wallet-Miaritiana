from datetime import datetime

class Wallet:
    def __init__(self):
        self.balance = 0
        self.transactions = []
        self.savings_goal = 0

    def display_balance(self):
        print(f"Your current balance is: {self.balance}")

    def add_funds(self):
        amount = int(input("Enter the amount to add: "))
        self.balance += amount
        self.transactions.append((datetime.now(), f"Added {amount} Ar to wallet"))
        print(f"Added {amount} Ar to wallet")

    def subtract_funds(self):
        amount = int(input("Enter the amount to subtract: "))
        if amount <= self.balance:
            self.balance -= amount
            self.transactions.append((datetime.now(), f"Subtracted {amount} Ar from wallet"))
            print(f"Subtract {amount} Ar from wallet")
        else:
            print("Insufficient funds. Transaction canceled.")

    def set_savings_goal(self):
        self.savings_goal = int(input("Enter your savings goal amount: "))
        print(f"Savings goal set to {self.savings_goal} Ar.")

    def track_savings_progress(self):
        print(f"Current savings progress: {self.balance} / {self.savings_goal} Ar")

    def get_all_transactions(self):
        for date, desc in self.transactions:
            print(f"{date}: {desc}")


if __name__ == '__main__':
    wallet = Wallet()

    print("Welcome to the wallet program")
    while True:
        print(
            '''
            1. Display Balance
            2. Add Funds
            3. Subtract Funds
            4. Set Savings Goal
            5. Track Savings Progress
            6. View All Transactions
            7. Quit
            '''
        )
        choice = int(input("Choose an option (1-7): "))

        if choice == 1:
            wallet.display_balance()
        elif choice == 2:
            wallet.add_funds()
        elif choice == 3:
            wallet.subtract_funds()
        elif choice == 4:
            wallet.set_savings_goal()
        elif choice == 5:
            wallet.track_savings_progress()
        elif choice == 6:
            wallet.get_all_transactions()
        elif choice == 7:
            print("Exiting wallet program. Goodbye!")
            break
        else:
            print("Invalid choice. Please choose a number between 1 and 7.")
