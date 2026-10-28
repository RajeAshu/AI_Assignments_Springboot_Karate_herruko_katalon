def check_balance(context):
    print(f"\n[Balance Info] {context['name']}, your current balance is: INR {context['balance']}")

def credit_card_services(context):
    print("\n--- Credit Card Application Portal ---")
    print("To proceed, please ensure you have the following documents ready:")
    print("1. Aadhaar Card (Identity & Address Proof)")
    print("2. PAN Card (Tax & Financial Verification)")
    print("3. Latest 3 Months Salary Slips")

def forex_card_services(context):
    print("\n--- Available Forex Card Services ---")
    print("- Buy/Sell foreign currency notes")
    print("- Reload existing Forex Card online")
    print("- Check multi-currency ledger balance")
    print("- Block lost/stolen Forex Card instantly")

def service_menu():
    print("\n--- Banking Service Menu ---")
    print("1. Check balance")
    print("2. Credit card services")
    print("3. Forex card services")
    print("4. Exit")

def main():
    print("--- Welcome to the Banking System ---")
    
    # Temporary memory context storing user data
    user_context = {
        "name": input("Please enter your name to begin: ").strip() or "Guest",
        "balance": 45500.25
    }

    # Map mapping string choices directly to their respective processing functions
    action_map = {
        "1": check_balance,
        "2": credit_card_services,
        "3": forex_card_services
    }

    while True:
        service_menu()
        choice = input("Please enter your choice (1-4): ").strip()

        if choice == "4":
            print(f"\nThank you for visiting, {user_context['name']}. Goodbye!")
            break
        
        # Look up the action in our dictionary map
        action = action_map.get(choice)
        
        if action:
            action(user_context) # Dynamically executes the mapped function passing the context
        else:
            print("\n[Error] Invalid choice. Please select 1, 2, 3, or 4.")

if __name__ == "__main__":
    main()
