/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

//package com.mycompany.datastructure;
import java.util.Stack;
/**
 *
 * @author carlconrad
 */
public class BuiltInStack {

    public static void main(String[] args) {
        
        Stack<Integer> stack = new Stack<>();
        
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
        
        
    }
}
