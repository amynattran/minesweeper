import tkinter as tk

def button_clicked():
    print("Button clicked!")

def create_window():
    root = tk.Tk()
    root.geometry("400x250")  # Set window size
    root.title("Minesweeper")  # Set window title

    button = tk.Button(root, 
                   text="Click Me", 
                   command=button_clicked,
                   activebackground="blue", 
                   activeforeground="white",
                   anchor="center",
                   bd=3,
                   bg="lightgray",
                   cursor="hand2",
                   disabledforeground="gray",
                   fg="black",
                   font=("Arial", 12),
                   height=2,
                   highlightbackground="black",
                   highlightcolor="green",
                   highlightthickness=2,
                   justify="center",
                   overrelief="raised",
                   padx=10,
                   pady=5,
                   width=15,
                   wraplength=100)
    button.pack(padx=20, pady=20)

    root.mainloop()

