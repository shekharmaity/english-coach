class ReadingDemoModel {
  const ReadingDemoModel({
    required this.lessonTitle,
    required this.categoryTitle,
    required this.sentenceText,
    required this.currentSentenceIndex,
    required this.totalSentences,
    required this.activeWordIndex,
    required this.readingSpeedWpm,
    required this.fontSize,
    required this.estimatedTimeLabel,
  });

  final String lessonTitle;
  final String categoryTitle;
  final String sentenceText;
  final int currentSentenceIndex;
  final int totalSentences;
  final int activeWordIndex;
  final double readingSpeedWpm;
  final double fontSize;
  final String estimatedTimeLabel;

  int get currentSentenceNumber {
    return currentSentenceIndex + 1;
  }

  double get completionPercent {
    if (totalSentences == 0) {
      return 0;
    }

    return currentSentenceNumber / totalSentences;
  }

  List<String> get words {
    return sentenceText.split(RegExp(r'\s+'));
  }

  ReadingDemoModel copyWith({double? readingSpeedWpm, double? fontSize}) {
    return ReadingDemoModel(
      lessonTitle: lessonTitle,
      categoryTitle: categoryTitle,
      sentenceText: sentenceText,
      currentSentenceIndex: currentSentenceIndex,
      totalSentences: totalSentences,
      activeWordIndex: activeWordIndex,
      readingSpeedWpm: readingSpeedWpm ?? this.readingSpeedWpm,
      fontSize: fontSize ?? this.fontSize,
      estimatedTimeLabel: estimatedTimeLabel,
    );
  }
}

const ReadingDemoModel demoReadingModel = ReadingDemoModel(
  lessonTitle: 'Lesson 5',
  categoryTitle: 'Daily Conversation',
  sentenceText:
      'Every day is a new opportunity to learn, improve, and become more confident.',
  currentSentenceIndex: 2,
  totalSentences: 20,
  activeWordIndex: 5,
  readingSpeedWpm: 120,
  fontSize: 34,
  estimatedTimeLabel: '2 min',
);
