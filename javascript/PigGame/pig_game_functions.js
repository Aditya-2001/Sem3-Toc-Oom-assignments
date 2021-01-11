scoreLimit = 100
function Roll(){
    return Math.floor(Math.random() * 5) + 1;
}

function SwitchPlayer(player){
    return 1-player
}

function calScore(score,oldScore){
    return score+oldScore
}

function gameInitialization(){
    var score = [0,0]
    var finalScore = [0,0]
    var player = Math.floor(Math.random() * 1)
    var gameActive = [true, true]
    return [score,finalScore,player,gameActive]
}

function resetScore(scoreArray,player){
    scoreArray[player] = 0
    return scoreArray
}

function CheckWinner(gameActive,player){
    if(gameActive[player])
        return player
    return SwitchPlayer(player)
}

function calTempScore(oldScore,diceValue,player){
    if(diceValue==1)
        return 0
    return calScore(oldScore[player],diceValue)
}


function duoGame(){
    var gameInitializer=gameInitialization()
    var score=gameInitializer[0]
    var finalScore = gameInitializer[1]
    var player=gameInitializer[2]
    var gameActive = gameInitializer[3]
    while(1){
        var valid = true
        score = resetScore(score,player)
        var turn=1
        while(valid){
            if(turn){
                ch=1
                turn=0
            }
            else
                ch = parseInt(prompt("Player " + (player + 1) + ", your temp score is " + score[player] + "\n1. Roll, 2. Pass the turn, 3. Quit"))
            switch(ch){
                case 1:
                    var diceValue=Roll()
                    score[player] = calTempScore(score,diceValue,player)
                    if(!score[player])
                        valid=false
                    break
                case 2:
                    valid = false
                    break
                case 3:
                    valid = false
                    gameActive[player] = false
                    break
                default:    
                    alert("Invalid input, Try Again")
            }
        }
        finalScore[player] = calScore(finalScore[player],score[player])
        alert("Player " + (player + 1) + " your score is " + finalScore[player])
        if(finalScore[player]>=scoreLimit || !gameActive[player])
            break;
        player = SwitchPlayer(player)
    }
    player=CheckWinner(gameActive,player)
    alert("Player " + (player + 1)  + " you have won")

}
