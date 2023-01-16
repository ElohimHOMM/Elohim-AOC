package de.elohim.aoc2022.day05;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InputSet {
    private static final Integer STACKS = 9;

    private List<Deque<Character>> stacks;
    private List<Instruction> inputInstructions;

    public InputSet (List<String> input) {
        inputInstructions = new ArrayList<>();
        stacks = new ArrayList<>();
        for(int i = 0; i < input.size(); i++) {
            if(i < STACKS) {
                stacks.add(stringToStack(input.get(i)));
            } else {
                inputInstructions.add(stringToInstruction(input.get(i)));
            }
        }
    }

    private Deque<Character> stringToStack(String input) {
        input = input.replaceAll("[\\[ \\]]", "");
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : input.toCharArray()) {
            deque.addFirst(c);
        }
        return deque;
    }

    private Instruction stringToInstruction(String input) {
        input = input.replaceAll("\\D+", " ").replaceFirst(" ", "").replaceAll(" {2}", " ");
        String[] inputs = input.split(" ");
        return new Instruction(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]), Integer.parseInt(inputs[2]));
    }
}
