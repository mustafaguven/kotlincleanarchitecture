package com.mguven.presentation.mapper

interface IViewMapper<out V, in D> {

    fun mapToView(type: D): V

}