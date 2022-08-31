package tests;

import models.FiniteAutomata;
import models.Status;
import models.Transition;

public class Test {

	/**
	 * Method Start -- Init Test Aplication
	 * @param args arguments of the main
	 */
		public static void main(String[] args) {
			
			//Create Deterministic Automata
			FiniteAutomata automata = new FiniteAutomata();
			
			//Create Status
			Status q0 = new Status("q0", 1);
			Status q1 = new Status("q1", 2);
			Status q2 = new Status("q2", 3);
			Status q3 = new Status("q3", 4);
			Status q4 = new Status("q4", 5);
			
			//Create Transitions
			Transition t1 = new Transition(q0, q1, 'a');
			Transition t2 = new Transition(q1, q2, 'b');
			Transition t3 = new Transition(q2, q3, 'a');
			Transition t4 = new Transition(q2, q4, 'a');
			Transition t5 = new Transition(q4, q4, 'a');
			Transition t6 = new Transition(q3, q3, 'b');



			//Add Status
			automata.addStatus(q0);
			automata.addStatus(q1);
			automata.addStatus(q2);
			automata.addStatus(q3);
			automata.addStatus(q4);

			
			//Add Initial Status
			automata.addInitialStatus(q0);
			
			//Add Final Status
			automata.addFinalStatus(q2);
			automata.addFinalStatus(q3);
			automata.addFinalStatus(q4);

			//automata.addFinalStatus(q2);
			
			//Add Transitions
			automata.addTransition(t1);
			automata.addTransition(t2);
			automata.addTransition(t3);
			automata.addTransition(t4);
			automata.addTransition(t5);
			automata.addTransition(t6);


			//Check chains
			//System.out.println(automata.isAccept("0a",q0));
			//System.out.println(automata.isAccept("00",q0));
			//System.out.println(automata.isAccept("0",q0));
			System.out.println("****RESULTADO PASO A PASO***** CADENA abbb");
			System.out.println(automata.checkChain("abbb",q0,""));
			
			System.out.println("****RESULTADO PASO A PASO**** CADENA abba");
			System.out.println(automata.checkChain("abba",q0,""));
			
			System.out.println("****RESULTADO PASO A PASO*****  CADENA babba");
			System.out.println(automata.checkChain("babba",q0,""));
			
			System.out.println("****RESULTADO PASO A PASO***** CADENA aba");
			System.out.println(automata.checkChain("aba",q0,""));
			
			System.out.println("****RESULTADO PASO A PASO*****  CADENA ab");
			System.out.println(automata.checkChain("ab",q0,""));
			
			System.out.println("****RESULTADO PASO A PASO***** CADENA aaab");
			System.out.println(automata.checkChain("aaab",q0,""));
			
			
			//System.out.println("\n\n\n****RESULTADO FINAL****");
			//System.out.println(automata.isAccept("abab",q0,""));

			//System.out.println(automata.isAccept("0001",q0));
			//System.out.println(automata.isAccept("010101",q0));
			/*System.out.println(automata.isAccept("001010"));
			System.out.println(automata.isAccept("010101"));
			System.out.println(automata.isAccept("01001"));
			System.out.println(automata.isAccept("01010100"));
			System.out.println(automata.isAccept("0101011")); */


		}//Method End
}
