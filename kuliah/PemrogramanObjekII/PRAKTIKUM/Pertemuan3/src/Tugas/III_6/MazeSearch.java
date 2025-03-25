package Tugas.III_6;

import Program.III_5.Maze;

public class MazeSearch {
    public static void main(String[] args) {
        Maze labyrinth = new Maze();
        System.out.println(labyrinth);
        if (labyrinth.traverse(0, 0))
            System.out.println("The maze was successfully traversed !");
        else
            System.out.println("There is no possible path.");

        System.out.println(labyrinth);
    }
}
