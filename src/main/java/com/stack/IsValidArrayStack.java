package com.stack;

import java.util.Stack;

/**
 * @author: fanbopeng
 * @Date: 2019/1/1 10:17
 * @Description:
 */
public class IsValidArrayStack {

    public static boolean isValid(String s){

        ArrayStack<Character> stack=new ArrayStack<>();
        char[] charArray = s.toCharArray();
        for (int i=0;i<charArray.length;i++){

            if (charArray[i]=='('||charArray[i]=='{'||charArray[i]=='['){


                stack.push(charArray[i]);

            }else{
                if (stack.isEmpty()){

                    return  false;
                }
                Character pop = stack.pop();
                if (charArray[i]==')'&&pop!='('){

                    return  false;
                }
                if (charArray[i]=='}'&&pop!='{'){

                    return  false;
                }
                if (charArray[i]==']'&&pop!='['){

                    return  false;
                }


            }

        }

            return stack.isEmpty();
    }


    public static void main(String[] args) {


        System.out.println(isValid("{{}}"));


    }



}
