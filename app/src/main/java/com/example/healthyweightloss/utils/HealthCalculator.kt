import com.example.healthyweightloss.data.model.Gender

object HealthCalculator {
    fun calculateBMI(weight: Float, height: Float): Float {
        val heightInMeters = height / 100
        return weight / (heightInMeters * heightInMeters)
    }

    fun getBMIStatus(bmi: Float): BMIStatus {
        return when {
            bmi < 18.5f -> BMIStatus.UNDERWEIGHT
            bmi < 24f -> BMIStatus.NORMAL
            bmi < 28f -> BMIStatus.OVERWEIGHT
            else -> BMIStatus.OBESE
        }
    }

    fun getHealthAdvice(bmiStatus: BMIStatus, age: Int, gender: Gender): String {
        return when (bmiStatus) {
            BMIStatus.UNDERWEIGHT -> "您的体重偏轻，建议：\n" +
                "1. 适当增加饮食量\n" +
                "2. 注意营养均衡\n" +
                "3. 进行适度力量训练"
            BMIStatus.NORMAL -> "您的体重正常，建议：\n" +
                "1. 保持健康的生活方式\n" +
                "2. 定期运动\n" +
                "3. 均衡饮食"
            BMIStatus.OVERWEIGHT -> "您的体重偏重，建议：\n" +
                "1. 控制饮食摄入\n" +
                "2. 增加有氧运动\n" +
                "3. 保持规律作息"
            BMIStatus.OBESE -> "您的体重超重，建议：\n" +
                "1. 严格控制饮食\n" +
                "2. 每天进行有氧运动\n" +
                "3. 建议咨询专业医生"
        }
    }
}

enum class BMIStatus {
    UNDERWEIGHT, NORMAL, OVERWEIGHT, OBESE
}