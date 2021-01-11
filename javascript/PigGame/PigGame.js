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

function rollDice(){
    var diceValue = Roll()
    document.getElementById('diceScore').innerHTML = diceValue;
    tempScore[player]=calScore(tempScore[player],diceValue)
    if(diceValue == 1){
        tempScore[player]=0
        rollBack()
    }
    document.getElementById('tempScore').innerHTML = tempScore[player];
}

function rollBack(){
    score[player]=calScore(score[player],tempScore[player])
    document.getElementById('Player'+(player+1)).innerHTML = score[player];
    if(score[player]>=100){
        alert("Player " + (player+1) + ", you have won!!Hurah Hurah")
        resetScore(score,player)
        document.getElementById('Player1').innerHTML = 0;
        document.getElementById('Player2').innerHTML = 0;
    }
    tempScore=resetScore(tempScore,player)
    player=SwitchPlayer(player)
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

var gameVar=gameInitialization()
var score=gameVar[0]
var tempScore=gameVar[1]
var player=gameVar[2]
document.getElementById('Player1').innerHTML = score[0];
document.getElementById('Player2').innerHTML = score[1];



function duoGame(){
    //document.getElementById('rollDice').removeAttribute("disabled")
    //document.getElementById('passTurn').removeAttribute("disabled")
    //or
    var button=document.getElementsByClassName('gameButton')
    for(i=0;i<button.length;i++)
        button[i].removeAttribute("disabled")
    //or
    //$("#rollDice").removeAttr("disabled")
    //or
    //$(".gameButton").removeAttr("disabled")

    //$("#rollDice").click(function(){
        //logic
    //})
    //$("#rollDice").attr("click",function(){
        //logic
    //})

}







function duoGame1(){
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
