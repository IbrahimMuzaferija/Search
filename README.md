# Search

<p align="center"><img src="https://raw.githubusercontent.com/IbrahimMuzaferija/Search/master/Search-UI.png"></p>

## Introduction

The main objective of this project is an JAVA application that implements various search algorithms to solve 3x3 Eigth puzzle. The puzzle initial states are read from puzzle .txt files available in project root file, and search algorithms are used to find set of actions that will order the puzzle in solution state. The search algorithm explores different actions and puzzle states after specific action to find optimum solution state. The application implements following search algorithms: Breath First Search, Uninform Cost Search, Depth First Search, Limited Depth First Search, Iterative Deepening Search, Greedy Breath First Search, A* Search and Beam Search. All search algorithms work in a similar manner, only difference is the methods they use to add successors to frontier. Those methods play a crucial role in time and calculation complexitiy of the search algorithms.
