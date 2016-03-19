#ifndef CALCULATOR_H
#define CALCULATOR_H

#include <QWidget>

QT_BEGIN_NAMESPACE
class QLineEdit;
QT_END_NAMESPACE
class Button;


class Calculator : public QWidget
{
    Q_OBJECT

public:
    Calculator(QWidget *parent = 0);

private slots:
    void digitClicked();
    void unaryOperatorClicked();
    void additiveOperatorClicked();
    void multiplicativeOperatorClicked();
    void equalClicked();
    void pointClicked();
    void changeSignClicked();
    void backspaceClicked();
    void clear();
    void clearAll();
    void clearMemory();
    void readMemory();
    void setMemory();
    void addToMemory();
    void constantClicked();

private:

    Button *createButton(const QString &text, const char *member);
    void divisionByZero();
    void rootFromNegative();
    bool calculate(double rightOperand, const QString &pendingOperator);

    double sumInMemory;

    double sumAccumulated;

    double factorAccumulated;

    QString pendingAdditiveOperator;

    QString pendingMultiplicativeOperator;

    bool waitingForOperand;

    QLineEdit *display;


    enum { NumDigitButtons = 10 };
    Button *digitButtons[NumDigitButtons] = {};
};


#endif
