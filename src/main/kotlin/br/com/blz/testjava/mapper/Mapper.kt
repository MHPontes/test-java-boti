package br.com.blz.testjava.mapper

interface Mapper<P, U> {

  fun map(p: P): U

}
