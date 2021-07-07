import random

restart = True
while restart:
    
    answer = random.sample(["green", "cyan", "red", "purple", "blue", "orange"], 4)
    print(answer)
    
    def mastermind(answer):
        end = 0
        for n in range(10):
            print("\n---------- Live left: %d ----------" %(10 - n))
            print("end: ", end)
            if (end == 4):
                print("Congratulation")
                break
            else:
                end = 0
                guess = []
                for i in range(4):
                    guess.append(input("Enter your colour (%d): " %(i + 1)))
            
            for i in range(4):
                if (guess[i] == answer[i]):
                    end+=1
                    print("Black")
                elif (guess[i] != answer[i]):
                    for j in range(4):
                        if (guess[i] == answer[j]):
                            print("White")
            if n == 9:
                print("You lose!")
                break
            
    mastermind(answer)
    
    if (input("Do you want to restart the game? ") == "y"):
        restart == True
    else: 
        restart == False
