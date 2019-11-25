package ru.molcom.model

import javax.persistence.*

@Entity
@Table(name = "links")
data class Link(
        @Id
        @GeneratedValue(generator = "my_seq")
        @SequenceGenerator(name = "my_seq", sequenceName = "links_seq", allocationSize = 1)
        var id: Long = 0,

        @Column
        var text: String = ""


)