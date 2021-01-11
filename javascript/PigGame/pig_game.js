debugger



function play_game(temp_score,wants_to_play_pl){
    if(!wants_to_play_pl)
        return temp_score
    var exit_score=0
    random_number=Math.floor(Math.random() * 5) + 1;
    temp_score+=random_number
    if(random_number==1){
        temp_score=0
        alert("Player A, the number generated is: 1, you your temperory score becomes: 0")
        return temp_score
    }
    choice = prompt("Number generated is: " + random_number + ", Temporary score is: " + temp_score + "\n1-> To add temporary score to main score, 2-> Take risk and roll dice again, 3-> Quit")
    write_choice=true
    while(write_choice){
        write_choice=false
        switch(choice){
            case "1":     return temp_score   
            case "2":     exit_score = play_game(temp_score,wants_to_play_pl)
                          break
            case "3":     wants_to_play_A=0
                          break
            default:      write_choice=true
                          alert("Wrong Input")
        }
        if(write_choice){
            choice = prompt("1-> To add temporary score to main score, 2-> Take risk and roll dice again, 3-> Quit")
        }
    }
    return exit_score
}

function start_single_game(score_A,wants_to_play_A){
    alert("Player A, let us start the game")
    while(score_A<score_limit && wants_to_play_A){
        ch=prompt("1-> Roll the dice, 2->Quit the game")
        switch(ch){
            case "1":   var inc=play_game(0,wants_to_play_A)
                        if(inc){
                            score_A+=inc
                            alert("Player A, current main score is: " + score_A)
                        }
                        break
            case "2":   wants_to_play_A=false
                        break
            default:    alert("Invalid input")
        }
    }
    if(wants_to_play_A){
        alert("Player A, you have completed the level with score: " + score_A)
    }
    else{
        alert("Player A, you exited from the game with score: " + score_A + ". Better luch next time")
    }
}

function start_duo_game(score_A,wants_to_play_A,score_B,wants_to_play_B){
    alert("Player A and B, let's starts the duo game")
    random_chance=Math.floor(Math.random() * 1);
    var turn = (random_chance==1)?"B":"A"
    while(score_A<score_limit && wants_to_play_A && score_B<score_limit && wants_to_play_B){
        ch=prompt("Player " + turn + ". 1-> Roll the dice, 2->Quit the game")
        invalid=false
        switch(turn + ch){
            case "A1":  var inc=play_game(0,wants_to_play_A)
                        if(inc){
                            score_A+=inc
                            alert("Player A, current main score is: " + score_A)
                        }
                        break
            case "A2":  wants_to_play_A=false
                        break
            case "B1":  var inc=play_game(0,wants_to_play_B)
                        if(inc){
                            score_B+=inc
                            alert("Player B, current main score is: " + score_B)
                        }
                        break
            case "B2":  wants_to_play_B=false
                        break
            default:    invalid=true
                        alert("Invalid input")
        }
        if(!invalid)
            turn = (turn=="A")?"B":"A"
    }
    if(score_A>=score_limit){
        alert("Congratulations! Player A you won with: " + (score_A-score_B) + " score.")
    }
    else if(score_B>=score_limit){
        alert("Congratulations! Player B you won with: " + (score_B-score_A) + " score.")
    }
    else if(!wants_to_play_A){
        alert("Player A, you exited from the game with score: " + score_A + ". Better luch next time")
        alert("Congratulations! Player B you won.")
    }
    else if(!wants_to_play_B){
        alert("Player B, you exited from the game with score: " + score_B + ". Better luch next time")
        alert("Congratulations! Player A you won.")
    }
}

score=0
score_limit=100
wants_to_play=1
start_duo_game(score,wants_to_play,score,wants_to_play)
//start_single_game(score,wants_to_play)