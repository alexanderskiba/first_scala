object abstask1 extends App {
//  Напишите несколько его реализаций:
//
//    tokenDeleter - в методе process обрабатывает строку, удаляя из неё перечисленные знаки препинания: запятая, точка, точка с запятой.
//    toLowerConvertor - заменяет все прописные буквы на строчные.
//  shortener - если строка имеет размер больше 20 символов, он оставляет первые 20 и добавляет к ней "...".

  trait StringProcessor {
    def process(input: String): String
  }

  val tokenDeleter: StringProcessor = new StringProcessor {
    override def process(input: String): String = {
      val result = input.replaceAll("[.;,]", "")
      result
    }
  }

  val toLowerConvertor: StringProcessor = new StringProcessor {
    override def process(input: String): String = {
      val res = input.toLowerCase
      res
    }
  }

  val shortener: StringProcessor = new StringProcessor {
    override def process(input: String): String = {
      if (input.length > 20) {
        val res1 = input.slice(0, 20) + "..."
        res1
      }
      else input
    }
  }

  println(shortener.process("1234567891233456788234234234234"))
  println(tokenDeleter.process("fejhdfdf.sf,dsfdsf;dsf"))
  println(toLowerConvertor.process("ASJAgahsdgsajhdjAJSHKJASHJKDBKJSADHJKSAHDBsdnsbf"))

}
