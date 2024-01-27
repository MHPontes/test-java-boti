package br.com.blz.testjava.mapper

interface Mapper<P, U> {            //Sera usada por todos os outros mappers
  fun map(p: P) : U
}
