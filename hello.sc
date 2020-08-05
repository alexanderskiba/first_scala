val x = BigInt(2).pow(10000).toString()
x.contains("777")

val reg ="(.)\\1".r

reg.findFirstMatchIn(x)