public class Sevens
{
    //Instance Variables
    private GVdie d1;
    private GVdie d2;
    private GVdie d3;
    private GVdie d4;
    private GVdie d5;
    private GVdie d6;
    private int player1Score;
    private int player2Score;
    private int numberOfRolls;
    private boolean isPlayer1Turn;
    //Constructor
    public Sevens()
    {
        d1 = new GVdie();
        d2 = new GVdie();
        d3 = new GVdie();
        d4 = new GVdie();
        d5 = new GVdie();
        d6 = new GVdie();
        player1Score = 0;
        player2Score = 0;
        numberOfRolls = 0;
        isPlayer1Turn = true;
    }
    //Accessor Methods
    public int getScore1()
    {
        return player1Score;
    }

    public int getScore2()
    {
        return player2Score;
    }

    public boolean isPlayer1turn()
    {
        return isPlayer1Turn;
    }

    public boolean turnOver()
    {
        boolean turnOver = false;
        if (numberOfRolls >= 3) 
        {
            turnOver = true;
        }
        return turnOver;
    }

    public boolean gameOver()
    {
        boolean gameOver = false;
        if (player1Score >= 77 || player2Score >= 77)
        {
            gameOver = true;  
        }
        return gameOver;
    }

    public GVdie getDie(int num)
    {
        if (num == 1)
        {
            return d1;
        }
        else if (num == 2)
        {
            return d2;
        }
        else if (num == 3)
        {
            return d3;
        }
        else if (num == 4)
        {
            return d4;
        }
        else if (num == 5)
        {
            return d5;
        }
        else
        {
            return d6;
        }
    }
    //Private Helper Methods
    private void resetDice()
    {
        d1.setHeld(false);
        d1.setFrozen(false);
        d1.setBlank();
        d2.setHeld(false);
        d2.setFrozen(false);
        d2.setBlank();
        d3.setHeld(false);
        d3.setFrozen(false);
        d3.setBlank();
        d4.setHeld(false);
        d4.setFrozen(false);
        d4.setBlank();
        d5.setHeld(false);
        d5.setFrozen(false);
        d5.setBlank();
        d6.setHeld(false);
        d6.setFrozen(false);
        d6.setBlank();
    }

    private int getDiceTotal()
    {
        int total = 0;
        if (d1.isHeld() == false)
        {
            total += d1.getValue();
        }
        if (d2.isHeld() == false)
        {
            total += d2.getValue();
        }
        if (d3.isHeld() == false)
        {
            total += d3.getValue();
        }
        if (d4.isHeld() == false)
        {
            total += d4.getValue();
        }
        if (d5.isHeld() == false)
        {
            total += d5.getValue();
        }
        if (d6.isHeld() == false)
        {
            total += d6.getValue();
        }
        return total;
    }

    private int getNumHeld()
    {
        int held = 0;
        if (d1.isHeld() == true)
        {
            held++;
        }
        if (d2.isHeld() == true)
        {
            held++;
        }
        if (d3.isHeld() == true)
        {
            held++;
        }
        if (d4.isHeld() == true)
        {
            held++;
        }
        if (d5.isHeld() == true)
        {
            held++;
        }
        if (d6.isHeld() == true)
        {
            held++;
        }
        return held;
    }

    private void freezeDice()
    {
        d1.setFrozen(true);
        d2.setFrozen(true);
        d3.setFrozen(true);
        d4.setFrozen(true);
        d5.setFrozen(true);
        d6.setFrozen(true);
    }

    private void showDice()
    {
        if (d1.isHeld() == true)
        {
            System.out.print("* ");
        }
        else
        {
            System.out.print(d1.getValue() + " ");
        }
        if (d2.isHeld() == true)
        {
            System.out.print("* ");
        }
        else
        {
            System.out.print(d2.getValue() + " ");
        }
        if (d3.isHeld() == true)
        {
            System.out.print("* ");
        }
        else
        {
            System.out.print(d3.getValue() + " ");
        }
        if (d4.isHeld() == true)
        {
            System.out.print("* ");
        }
        else
        {
            System.out.print(d4.getValue() + " ");
        }
        if (d5.isHeld() == true)
        {
            System.out.print("* ");
        }
        else
        {
            System.out.print(d5.getValue() + " ");
        }
        if (d6.isHeld() == true)
        {
            System.out.println("* ");
        }
        else
        {
            System.out.println(d6.getValue() + " ");
        }
    }
    //Mutator Methods
    public void rollDice()
    {
        if (numberOfRolls < 3 && isValidHand() == true)
        {
            if (d1.isHeld() == false)
            {
                d1.roll();
            }
            if (d2.isHeld() == false)
            {
                d2.roll();
            }
            if (d3.isHeld() == false)
            {
                d3.roll();
            }
            if (d4.isHeld() == false)
            {
                d4.roll();
            }
            if (d5.isHeld() == false)
            {
                d5.roll();
            }
            if (d6.isHeld() == false)
            {
                d6.roll();
            }
        }
        numberOfRolls++;
        checkValidOptions();
    }

    public void passDice()
    {
        if (isPlayer1Turn == true)
        {
            player1Score = player1Score + getDiceTotal();
        }
        else
        {
            player2Score = player2Score + getDiceTotal();
        }
        isPlayer1Turn = !isPlayer1Turn;
        numberOfRolls = 0;
        resetDice();
    }

    public void resetGame()
    {
        player1Score = 0;
        player2Score = 0;
        numberOfRolls = 0;
        resetDice();
    }
    //Preventing Player Errors
    private void checkValidOptions()
    {
        if (!d1.isHeld() && !d2.isHeld() && (d1.getValue() + d2.getValue() == 7))
        {
        }
        else if (!d1.isHeld() && !d3.isHeld() && (d1.getValue() + d3.getValue() == 7))
        {
        }
        else if (!d1.isHeld() && !d4.isHeld() && (d1.getValue() + d4.getValue() == 7))
        {
        }
        else if (!d1.isHeld() && !d5.isHeld() && (d1.getValue() + d5.getValue() == 7))
        {
        }
        else if (!d1.isHeld() && !d6.isHeld() && (d1.getValue() + d6.getValue() == 7))
        {
        }
        else if (!d2.isHeld() && !d3.isHeld() && (d2.getValue() + d3.getValue() == 7))
        {
        }
        else if (!d2.isHeld() && !d4.isHeld() && (d2.getValue() + d4.getValue() == 7))
        {
        }
        else if (!d2.isHeld() && !d5.isHeld() && (d2.getValue() + d5.getValue() == 7))
        {
        }
        else if (!d2.isHeld() && !d6.isHeld() && (d2.getValue() + d6.getValue() ==7))
        {
        }
        else if (!d3.isHeld() && !d4.isHeld() && (d3.getValue() + d4.getValue() == 7))
        {
        }
        else if (!d3.isHeld() && !d5.isHeld() && (d3.getValue() + d5.getValue() == 7))
        {
        }
        else if (!d3.isHeld() && !d6.isHeld() && (d3.getValue() + d6.getValue() == 7))
        {
        }
        else if (!d4.isHeld() && !d5.isHeld() && (d4.getValue() + d5.getValue() == 7))
        {
        }
        else if (!d4.isHeld() && !d6.isHeld() && (d4.getValue() + d6.getValue() == 7))
        {
        }
        else if (!d5.isHeld() && !d6.isHeld() && (d5.getValue() + d6.getValue() == 7))
        {
        }
        else
        {
            numberOfRolls = 3;
            this.freezeDice();
        }
    }
    /**private void checkValidOptions()
    {
        //boolean isValid=false;
        if (!d1.isHeld() && !d2.isHeld() && (d1.getValue() + d2.getValue() == 7))
        {
        }
        if (d1.isHeld() == false && d3.isHeld() == false && (d1.getValue() + d3.getValue() == 7))
        {
            numberOfRolls = 3;
        }
        if (d1.isHeld() == false && d4.isHeld() == false && (d1.getValue() + d4.getValue() == 7))
        {
            numberOfRolls = 3;
            freezeDice();
        }
        if (d1.isHeld() == false && d5.isHeld() == false && (d1.getValue() + d5.getValue() == 7))
        {
            numberOfRolls = 3;
            freezeDice();
        }
        if (d1.isHeld() == false && d6.isHeld() == false && (d1.getValue() + d6.getValue() == 7))
        {
            numberOfRolls = 3;
            freezeDice();
        }
        if (d2.isHeld() == false && d3.isHeld() == false && (d2.getValue() + d3.getValue() == 7))
        {
            numberOfRolls = 3;
            freezeDice();
        }
        if (d2.isHeld() == false && d4.isHeld() == false && (d2.getValue() + d4.getValue() == 7))
        {
            numberOfRolls = 3;
            freezeDice();
        }
        if (d2.isHeld() == false && d5.isHeld() == false && (d2.getValue() + d5.getValue() == 7))
        {
            numberOfRolls = 3;
            freezeDice();
        }
        if (d2.isHeld() == false && d6.isHeld() == false && (d2.getValue() + d6.getValue() ==7))
        {
            numberOfRolls = 3;
            freezeDice();
        }
        if (d3.isHeld() == false && d4.isHeld() == false && (d3.getValue() + d4.getValue() == 7))
        {
            numberOfRolls = 3;
            freezeDice();
        }
        if (d3.isHeld() == false && d5.isHeld() == false && (d3.getValue() + d5.getValue() == 7))
        {
            numberOfRolls = 3;
            freezeDice();
        }
        if (d3.isHeld() == false && d6.isHeld() == false && (d3.getValue() + d6.getValue() == 7))
        {
            numberOfRolls = 3;
            freezeDice();
        }
        if (d4.isHeld() == false && d5.isHeld() == false && (d4.getValue() + d5.getValue() == 7))
        {
            numberOfRolls = 3;
            freezeDice();
        }
        if (d4.isHeld() == false && d6.isHeld() == false && (d4.getValue() + d6.getValue() == 7))
        {
            numberOfRolls = 3;
            freezeDice();
        }
        if (d5.isHeld() == false && d6.isHeld() == false && (d5.getValue() + d6.getValue() == 7))
        {
            numberOfRolls = 3;
            freezeDice();
        }
        if(isValid==false)
        {
            numberOfRolls = 3;
            freezeDice();
        }
    
    */
    private boolean isValidHand()
    {
        boolean isValidHand = false;
        if (numberOfRolls == 0 && getNumHeld() == 0)
        {
            isValidHand = true;
        }
        if (numberOfRolls == 1 && getNumHeld() == 2)
        {
            if (d1.isHeld() && d2.isHeld() && d1.getValue() + d2.getValue() == 7)
            {
                isValidHand = true;
            }
            else if (d1.isHeld() && d3.isHeld() && d1.getValue() + d3.getValue() == 7)
            {
                isValidHand = true;
            }
            else if (d1.isHeld() && d4.isHeld() && d1.getValue() + d4.getValue() == 7)
            {
                isValidHand = true;
            }
            else if (d1.isHeld() && d5.isHeld() && d1.getValue() + d5.getValue() == 7)
            {
                isValidHand = true;
            }
            else if (d1.isHeld() && d6.isHeld() && d1.getValue() + d6.getValue() == 7)
            {
                isValidHand = true;
            }
            else if (d2.isHeld() && d3.isHeld() && d2.getValue() + d3.getValue() == 7)
            {
                isValidHand = true;
            }
            else if (d2.isHeld() && d4.isHeld() && d2.getValue() + d4.getValue() == 7)
            {
                isValidHand = true;
            }
            else if (d2.isHeld() && d5.isHeld() && d2.getValue() + d5.getValue() == 7)
            {
                isValidHand = true;
            }
            else if (d2.isHeld() && d6.isHeld() && d2.getValue() + d6.getValue() == 7)
            {
                isValidHand = true;
            }
            else if (d3.isHeld() && d4.isHeld() && d3.getValue() + d4.getValue() == 7)
            {
                isValidHand = true;
            }
            else if (d3.isHeld() && d5.isHeld() && d3.getValue() + d5.getValue() == 7)
            {
                isValidHand = true;
            }
            else if (d3.isHeld() && d6.isHeld() && d3.getValue() + d6.getValue() == 7)
            {
                isValidHand = true;
            }
            else if (d4.isHeld() && d5.isHeld() && d4.getValue() + d5.getValue() == 7)
            {
                isValidHand = true;
            }
            else if (d4.isHeld() && d6.isHeld() && d4.getValue() + d6.getValue() == 7)
            {
                isValidHand = true;
            }
            else if (d5.isHeld() && d6.isHeld() && d5.getValue() + d6.getValue() == 7)
            {
                isValidHand = true;
            }
        }
        if (numberOfRolls == 2 && getNumHeld() == 4)
        {
            if (d1.isHeld() == true && d2.isHeld() == true && d3.isHeld() == true && d4.isHeld() == true && (d1.getValue() + d2.getValue() + d3.getValue() + d4.getValue() == 14))
            {
                isValidHand = true;
            }
            else if (d1.isHeld() == true && d2.isHeld() == true && d3.isHeld() == true && d5.isHeld() == true && (d1.getValue() + d2.getValue() + d3.getValue() + d5.getValue() == 14))
            {
                isValidHand = true;
            }
            else if (d1.isHeld() == true && d2.isHeld() == true && d3.isHeld() == true && d6.isHeld() == true && (d1.getValue() + d2.getValue() + d3.getValue() + d6.getValue() == 14))
            {
                isValidHand = true;
            }
            else if (d1.isHeld() == true && d2.isHeld() == true && d4.isHeld() == true && d5.isHeld() == true && (d1.getValue() + d2.getValue() + d4.getValue() + d5.getValue() == 14))
            {
                isValidHand = true;
            }
            else if (d1.isHeld() == true && d2.isHeld() == true && d4.isHeld() == true && d6.isHeld() == true && (d1.getValue() + d2.getValue() + d4.getValue() + d6.getValue() == 14))
            {
                isValidHand = true;
            }
            else if (d1.isHeld() == true && d2.isHeld() == true && d5.isHeld() == true && d6.isHeld() == true && (d1.getValue() + d2.getValue() + d5.getValue() + d6.getValue() == 14))
            {
                isValidHand = true;
            }
            else if (d1.isHeld() == true && d3.isHeld() == true && d4.isHeld() == true && d5.isHeld() == true && (d1.getValue() + d3.getValue() + d4.getValue() + d5.getValue() == 14))
            {
                isValidHand = true;
            }
            else if (d1.isHeld() == true && d3.isHeld() == true && d4.isHeld() == true && d6.isHeld() == true && (d1.getValue() + d3.getValue() + d4.getValue() + d6.getValue() == 14))
            {
                isValidHand = true;
            }
            else if (d1.isHeld() == true && d3.isHeld() == true && d5.isHeld() == true && d6.isHeld() == true && (d1.getValue() + d3.getValue() + d5.getValue() + d6.getValue() == 14))
            {
                isValidHand = true;
            }
            else if (d1.isHeld() == true && d4.isHeld() == true && d5.isHeld() == true && d6.isHeld() == true && (d1.getValue() + d4.getValue() + d5.getValue() + d6.getValue() == 14))
            {
                isValidHand = true;
            }
            else if (d2.isHeld() == true && d3.isHeld() == true && d4.isHeld() == true && d5.isHeld() == true && (d2.getValue() + d3.getValue() + d4.getValue() + d5.getValue() == 14))
            {
                isValidHand = true;
            }
            else if (d2.isHeld() == true && d3.isHeld() == true && d4.isHeld() == true && d6.isHeld() == true && (d2.getValue() + d3.getValue() + d4.getValue() + d6.getValue() == 14))
            {
                isValidHand = true;
            }
            else if (d2.isHeld() == true && d3.isHeld() == true && d5.isHeld() == true && d6.isHeld() == true && (d2.getValue() + d3.getValue() + d5.getValue() + d6.getValue() == 14))
            {
                isValidHand = true;
            }
            else if (d2.isHeld() == true && d4.isHeld() == true && d5.isHeld() == true && d6.isHeld() == true && (d2.getValue() + d4.getValue() + d5.getValue() + d6.getValue() == 14))
            {
                isValidHand = true;
            }
            else if (d3.isHeld() == true && d4.isHeld() == true && d5.isHeld() == true && d6.isHeld() == true && (d3.getValue() + d4.getValue() + d5.getValue() + d6.getValue() == 14))
            {
                isValidHand = true;
            }
        }
        return isValidHand;
    }

    //Software Testing
    private void autoHold()
    {
        if (d1.isHeld() == false && d2.isHeld() == false && (d1.getValue() + d2.getValue() == 7))
        {
            d1.setHeld(true);
            d2.setHeld(true);
        }
        else if (d1.isHeld() == false && d3.isHeld() == false && (d1.getValue() + d3.getValue() == 7))
        {
            d1.setHeld(true);
            d3.setHeld(true);
        }
        else if (d1.isHeld() == false && d4.isHeld() == false && (d1.getValue() + d4.getValue() == 7))
        {
            d1.setHeld(true);
            d4.setHeld(true);
        }
        else if (d1.isHeld() == false && d5.isHeld() == false && (d1.getValue() + d5.getValue() == 7))
        {
            d1.setHeld(true);
            d5.setHeld(true);
        }
        else if (d1.isHeld() == false && d6.isHeld() == false && (d1.getValue() + d6.getValue() == 7))
        {
            d1.setHeld(true);
            d6.setHeld(true);
        }
        else if (d2.isHeld() == false && d3.isHeld() == false && (d2.getValue() + d3.getValue() == 7))
        {
            d2.setHeld(true);
            d3.setHeld(true);
        }
        else if (d2.isHeld() == false && d4.isHeld() == false && (d2.getValue() + d4.getValue() == 7))
        {
            d2.setHeld(true);
            d4.setHeld(true);
        }
        else if (d2.isHeld() == false && d5.isHeld() == false && (d2.getValue() + d5.getValue() == 7))
        {
            d2.setHeld(true);
            d5.setHeld(true);
        }
        else if (d2.isHeld() == false && d6.isHeld() == false && (d2.getValue() + d6.getValue() == 7))
        {
            d2.setHeld(true);
            d6.setHeld(true);
        }
        else if (d3.isHeld() == false && d4.isHeld() == false && (d3.getValue() + d4.getValue() == 7))
        {
            d3.setHeld(true);
            d4.setHeld(true);
        }
        else if (d3.isHeld() == false && d5.isHeld() == false && (d3.getValue() + d5.getValue() == 7))
        {
            d3.setHeld(true);
            d5.setHeld(true);
        }
        else if (d3.isHeld() == false && d6.isHeld() == false && (d3.getValue() + d6.getValue() == 7))
        {
            d3.setHeld(true);
            d6.setHeld(true);
        }
        else if (d4.isHeld() == false && d5.isHeld() == false && (d4.getValue() + d5.getValue() == 7))
        {
            d4.setHeld(true);
            d5.setHeld(true);
        }
        else if (d4.isHeld() == false && d6.isHeld() == false && (d4.getValue() + d6.getValue() == 7))
        {
            d4.setHeld(true);
            d6.setHeld(true);
        }
        else if (d5.isHeld() == false && d6.isHeld() == false && (d5.getValue() + d6.getValue() == 7))
        {
            d5.setHeld(true);
            d6.setHeld(true);
        }
        else
        {
            numberOfRolls = 3;
        }
    }

    private void autoTurn()
    {
        while (!turnOver())
        {
            rollDice();
            showDice();
            autoHold();
        }
        passDice();   
    }

    public void autoGame()
    {
        while (gameOver() == false)
        {
            if (isPlayer1turn())
            {
                System.out.println("Player 1: " + getScore1());
            }
            else
            {
                System.out.println("Player 2: " + getScore2());
            }
            autoTurn();
        }
        if (getScore1() >= 77)
        {
            System.out.println("Game Over");
            System.out.println("Player 1: " + player1Score);
            System.out.println("Player 2: " + player2Score);
            System.out.println("Player 2 Wins");
        }
        else if (getScore2() >= 77)
        {
            System.out.println("Game Over");
            System.out.println("Player 1: " + player1Score);
            System.out.println("Player 2: " + player2Score);
            System.out.println("Player 1 Wins");
        }
    }

    /**private boolean isValidHand()
    {
    boolean isValidHand = false;
    if (numberOfRolls == 0)
    {
    if (d1.isHeld() == false && d2.isHeld() == false && d3.isHeld() == false && d4.isHeld() == false && d5.isHeld() == false && d6.isHeld() == false)
    {
    isValidHand = true;
    }
    }
    if (numberOfRolls == 1)
    {
    if (d1.isHeld() == true && d2.isHeld() == true && d3.isHeld() == false && d4.isHeld() == false && d5.isHeld() == false && d6.isHeld() == false && (d1.getValue() + d2.getValue() == 7))
    {
    isValidHand = true;
    }
    else if (d1.isHeld() == true && d2.isHeld() == false && d3.isHeld() == true && d4.isHeld() == false && d5.isHeld() == false && d6.isHeld() == false && (d1.getValue() + d3.getValue() == 7))
    {
    isValidHand = true;
    }
    else if (d1.isHeld() == true && d2.isHeld() == false && d3.isHeld() == false && d4.isHeld() == true && d5.isHeld() == false && d6.isHeld() == false && (d1.getValue() + d4.getValue() == 7))
    {
    isValidHand = true;
    }
    else if (d1.isHeld() == true && d2.isHeld() == false && d3.isHeld() == false && d4.isHeld() == false && d5.isHeld() == true && d6.isHeld() == false && (d1.getValue() + d5.getValue() == 7))
    {
    isValidHand = true;
    }
    else if (d1.isHeld() == true && d2.isHeld() == false && d3.isHeld() == false && d4.isHeld() == false && d5.isHeld() == false && d6.isHeld() == true && (d1.getValue() + d6.getValue() == 7))
    {
    isValidHand = true;
    }
    else if (d1.isHeld() == false && d2.isHeld() == true && d3.isHeld() == true && d4.isHeld() == false && d5.isHeld() == false && d6.isHeld() == false && (d2.getValue() + d3.getValue() == 7))
    {
    isValidHand = true;
    }
    else if (d1.isHeld() == false && d2.isHeld() == true && d3.isHeld() == false && d4.isHeld() == true && d5.isHeld() == false && d6.isHeld() == false && (d2.getValue() + d4.getValue() == 7))
    {
    isValidHand = true;
    }
    else if (d1.isHeld() == false && d2.isHeld() == true && d3.isHeld() == false && d4.isHeld() == false && d5.isHeld() == true && d6.isHeld() == false && (d2.getValue() + d5.getValue() == 7))
    {
    isValidHand = true;
    }
    else if (d1.isHeld() == false && d2.isHeld() == true && d3.isHeld() == false && d4.isHeld() == false && d5.isHeld() == false && d6.isHeld() == true && (d2.getValue() + d6.getValue() == 7))
    {
    isValidHand = true;
    }
    else if (d1.isHeld() == false && d2.isHeld() == false && d3.isHeld() == true && d4.isHeld() == true && d5.isHeld() == false && d6.isHeld() == false && (d3.getValue() + d4.getValue() == 7))
    {
    isValidHand = true;
    }
    else if (d1.isHeld() == false && d2.isHeld() == false && d3.isHeld() == true && d4.isHeld() == false && d5.isHeld() == true && d6.isHeld() == false && (d3.getValue() + d5.getValue() == 7))
    {
    isValidHand = true;
    }
    else if (d1.isHeld() == false && d2.isHeld() == false && d3.isHeld() == true && d4.isHeld() == false && d5.isHeld() == false && d6.isHeld() == true && (d3.getValue() + d6.getValue() == 7))
    {
    isValidHand = true;
    }
    else if (d1.isHeld() == false && d2.isHeld() == false && d3.isHeld() == false && d4.isHeld() == true && d5.isHeld() == true && d6.isHeld() == false && (d4.getValue() + d5.getValue() == 7))
    {
    isValidHand = true;
    }
    else if (d1.isHeld() == false && d2.isHeld() == false && d3.isHeld() == false && d4.isHeld() == true && d5.isHeld() == false && d6.isHeld() == true && (d4.getValue() + d6.getValue() == 7))
    {
    isValidHand = true;
    }
    else if (d1.isHeld() == false && d2.isHeld() == false && d3.isHeld() == false && d4.isHeld() == false && d5.isHeld() == true && d6.isHeld() == true && (d5.getValue() + d6.getValue() == 7))
    {
    isValidHand = true;
    }
    }
    if (numberOfRolls == 2)
    {
    if (d1.isHeld() == true && d2.isHeld() == true && d3.isHeld() == true && d4.isHeld() == true && d5.isHeld() == false && d6.isHeld() == false && (d1.getValue() + d2.getValue() + d3.getValue() + d4.getValue() == 14)
    {
    isValidHand = true;
    }
    else if (d1.isHeld() == true && d2.isHeld() == true && d3.isHeld() == true && d4.isHeld() == true && d5.isHeld() == false && d6.isHeld() == false && (d1.getValue() + d2.getValue() + d3.getValue() + d4.getValue() == 14))
    {
    isValidHand = true;
    }
    }
    return isValidHand;
    }**/
}
