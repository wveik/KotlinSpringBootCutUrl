package ru.fnnetrolle.smlr.model

import javax.persistence.*

@Entity
@Table(name = "links")
data class Link(
        var text: String = "",
        @Id
        @GeneratedValue(strategy = javax.persistence.GenerationType.SEQUENCE, generator = "links_sequence")
        @SequenceGenerator(name = "links_sequence", sequenceName = "links_seq")
        var id: Long = 0
)