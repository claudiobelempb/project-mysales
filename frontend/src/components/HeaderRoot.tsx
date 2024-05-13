import { Alert, AlertRoot } from './AlertRoot';
import { HeadingH1, HeadingH2 } from './HeadingRoot';

interface HeaderProps {
  title: string;
  subTitle: string;
  children?: React.ReactNode;
  alerts?: Array<Alert>;
}

export const HeaderRoot: React.FC<HeaderProps> = ({
  title,
  subTitle,
  alerts,
  children
}: HeaderProps) => {
  return (
    <div>
      <HeadingH1>{title}</HeadingH1>
      <HeadingH2>{subTitle}</HeadingH2>
      {alerts &&
        alerts.map(alert => (
          <>
            <AlertRoot {...alert} />
          </>
        ))}
    </div>
  );
};
