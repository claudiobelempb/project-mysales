import { Heading } from '../heading';

interface HeaderProps {
  title: string;
  subTitle: string;
  children?: React.ReactNode;
}

export const Header: React.FC<HeaderProps> = ({
  title,
  subTitle
}: HeaderProps) => {
  return (
    <div>
      <Heading title={title} subTitle={subTitle} />
    </div>
  );
};
