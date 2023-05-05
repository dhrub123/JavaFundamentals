package com.dhruba.replit.two.oops.abstraction;

class Executor{
  public static void main(String args[]){
    Animal cat = new Cat();
    Animal dog = new Dog();

    cat.move();
    dog.move();

    cat.makeSound();
    dog.makeSound();
  }
}