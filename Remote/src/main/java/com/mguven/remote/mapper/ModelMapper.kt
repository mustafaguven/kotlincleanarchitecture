package com.mguven.remote.mapper

interface ModelMapper<M, E> {

    fun mapFromModel(model: M): E

}