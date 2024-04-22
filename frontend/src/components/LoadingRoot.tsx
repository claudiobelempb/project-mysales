import { CircleDashed } from 'lucide-react';
import { ComponentProps } from 'react';

type LoadingRootProps = ComponentProps<'div'>;

export const LoadingRoot: React.FC<LoadingRootProps> = props => {
  return (
    <div {...props} className='flex items-center justify-center min-h-screen'>
      {props.children}
    </div>
  );
};

type LoadingSvgProps = ComponentProps<'svg'>;

export const LoadingSvg: React.FC<LoadingSvgProps> = props => {
  return (
    <CircleDashed
      {...props}
      className={`animate-spin transition duration-700 ${props.className}`}
    />
  );
};
