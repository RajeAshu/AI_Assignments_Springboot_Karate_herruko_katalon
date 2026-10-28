def service_menu():
    print("1. Check balance")
    print("2. Credit card services")
    print("3. Forex card services")
    print("4. Exit")



def main():
    while True:
        service_menu()
        choice = input("Please enter your choice (1-4): ").strip()

        match choice:
            case "1":
                print("\n You selected: Check balance")
            case "2":
                print("\n You selected: Credit card services")
            case "3":
                print("\n You selected: Forex card services")
            case "4":
                print("\n Goodbye!")
                break 
            case _:
                print("\n Invalid choice. Please select 1, 2, 3, or 4.")

if __name__ == "__main__":
    main()




def check_balance():
    print("\nYour current account balance is ₹25,450.00")


def credit_card_services():
    print("\nCredit card documents required:")
    print("1. Aadhaar card")
    print("2. PAN card")


def forex_card_services():
    print("\nForex card services available:")
    print("1. Apply for a forex card")
    print("2. Check forex card balance")
    print("3. Reload forex card")
    print("4. Block or unblock forex card")


SERVICE_MAP = {
    "1": check_balance,
    "2": credit_card_services,
    "3": forex_card_services,
}


def service_menu():
    print("\n1. Check balance")
    print("2. Credit card services")
    print("3. Forex card services")
    print("4. Exit")


def main():
    while True:
        service_menu()
        choice = input("Please enter your choice (1-4): ").strip()

        if choice == "4":
            print("\nGoodbye!")
            break

        service = SERVICE_MAP.get(choice)

        if service:
            service()
        else:
            print("\nInvalid choice. Please select 1, 2, 3, or 4.")


if __name__ == "__main__":
    main()