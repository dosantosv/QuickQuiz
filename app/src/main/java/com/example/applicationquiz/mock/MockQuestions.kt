package com.example.applicationquiz.view

class MockQuestions {

    companion object {
        val questionOne = "Normalmente, quantos litros de sangue uma pessoa tem? Em média, quantos são retirados numa doação de sangue?"
        val responseOne = mutableMapOf("Tem entre 4 a 6 litros. São retirados 450 mililitros"
                to listOf(
            "Tem entre 2 a 4 litros. São retirados 450 mililitros",
            "Tem entre 4 a 6 litros. São retirados 450 mililitros",
            "Tem 10 litros. São retirados 2 litros",
            "Tem 7 litros. São retirados 1,5 litros"
        )
        )

        val questionTwo = "De quem é a famosa frase “Penso, logo existo”?"
        val responseTwo = mutableMapOf("Descartes"
                to listOf(
            "Platão",
            "Galileu Galilei",
            "João Cleber",
            "Descartes",
        )
        )

        val questionThree = "De onde é a invenção do chuveiro elétrico?"
        val responseThree = mutableMapOf("Brasil"
                to listOf(
            "Alemanha",
            "Itatinga",
            "Italia",
            "Brasil"
        )
        )

        val questionFour = "Quais o menor e o maior país do mundo?"
        val responseFour = mutableMapOf("Vaticano e Rússia"
                to listOf(
            "Vaticano e Rússia",
            "Itatiba e Brasil",
            "Mônaco e Canadá",
            "Malta e Estados Unidos"
        )
        )

    }

}