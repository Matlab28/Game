package com.example.game.service;

import com.example.game.dto.RspDto;
import com.example.game.dto.ToolsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class RspService {
    private final Random random = new Random();

    public String play(RspDto dto) {
        int computer = random.nextInt(3);
        String answer;

        switch (computer) {
            case 0:
                answer = ToolsDto.ROCK.getValues();
                break;
            case 1:
                answer = ToolsDto.PAPER.getValues();
                break;
            case 2:
                answer = ToolsDto.SCISSORS.getValues();
                break;
            default:
                return "Error";
        }

        if (dto.getUserAnswer().equalsIgnoreCase("rock")) {
            String result = "Your choice is rock, mine is " + answer + ".\n";
            return switch (computer) {
                case 0 -> result + "Wow, game is tie!";
                case 1 -> result + "You lost, I won!..";
                case 2 -> result + "Congratulations! You won!";
                default -> "Invalid input";
            };
        } else if (dto.getUserAnswer().equalsIgnoreCase("paper")) {
            String result = "Your choice is paper, mine is " + answer + ".\n";
            return switch (computer) {
                case 0 -> result + "Congratulations! You won!";
                case 1 -> result + "Wow, game is tie!";
                case 2 -> result + "You lost, I won!..";
                default -> "Invalid input";
            };
        } else if (dto.getUserAnswer().equalsIgnoreCase("scissors")) {
            String result = "Your choice is scissors, mine is " + answer + ".\n";
            return switch (computer) {
                case 0 -> result + "You lost, I won!..";
                case 1 -> result + "Congratulations! You won!";
                case 2 -> result + "Wow, game is tie!";
                default -> "Invalid input";
            };
        }
        return "Please enter only rock, scissors, or paper...";
    }
}

